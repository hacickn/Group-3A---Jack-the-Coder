package com.jack_the_coder.bilboard_backend.serviceImplementation;

import com.jack_the_coder.bilboard_backend.exception.UserServiceException;
import com.jack_the_coder.bilboard_backend.io.entity.*;
import com.jack_the_coder.bilboard_backend.io.repository.*;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateBuildingRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateClassroomDayRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateClassroomRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateTimeSlotRequest;
import com.jack_the_coder.bilboard_backend.service.ReservationService;
import com.jack_the_coder.bilboard_backend.shared.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImp implements ReservationService {


    @Autowired
    LocationRequestRepository locationRequestRepository;

    @Autowired
    LocationRequestTimeSlotRepository locationRequestTimeSlotRepository;

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    ClassroomDayRepository classroomDayRepository;

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Override
    public LocationRequestDto createLocationRequest ( List<Long> timeSlotIdList , EventEntity eventEntity ) {
        ModelMapper modelMapper = new ModelMapper();

        LocationRequestDto locationRequestDto = new LocationRequestDto();
        locationRequestDto.setAnswered( false );
        locationRequestDto.setConfirmed( false );
        locationRequestDto.setNeededNumberOfSpaces( eventEntity.getMaxParticipationCount() );
        locationRequestDto.setEvent( eventEntity );
        LocationRequestEntity locationRequestEntity =
                modelMapper.map( locationRequestDto , LocationRequestEntity.class );
        LocationRequestEntity created = locationRequestRepository.save( locationRequestEntity );

        List<LocationRequestTimeSlotEntity> requestTimeSlots = new ArrayList<>();

        timeSlotIdList.forEach( id -> {
            Optional<TimeSlotEntity> timeSlotEntity = timeSlotRepository.findById( id );

            if ( timeSlotEntity.isPresent() ) {
                LocationRequestTimeSlotDto locationRequestTimeSlotDto = new LocationRequestTimeSlotDto();
                locationRequestTimeSlotDto.setTimeSlot( timeSlotEntity.get() );
                locationRequestTimeSlotDto.setLocationRequest( created );
                requestTimeSlots.add( modelMapper.map( locationRequestDto , LocationRequestTimeSlotEntity.class ) );
            }
        } );

        List<LocationRequestTimeSlotEntity> createdTimeSlots =
                locationRequestTimeSlotRepository.saveAll( requestTimeSlots );
        created.setLocationRequestTimeSlots( createdTimeSlots );
        return modelMapper.map( created , LocationRequestDto.class );
    }

    @Override
    public BuildingDto createBuilding ( CreateBuildingRequest createBuildingRequest ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Optional<UniversityEntity> universityEntity =
                    universityRepository.findById( createBuildingRequest.getUniversity() );

            if ( universityEntity.isPresent() ) {
                BuildingDto buildingDto = new BuildingDto();
                buildingDto.setName( createBuildingRequest.getName() );
                buildingDto.setUniversity( universityEntity.get() );
                BuildingEntity created =
                        buildingRepository.save( modelMapper.map( buildingDto , BuildingEntity.class ) );

                return modelMapper.map( created , BuildingDto.class );
            } else {
                throw new UserServiceException( "University is NOT found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
        }
    }

    @Override
    public ClassroomDto createClassroom ( CreateClassroomRequest createClassroomRequest ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Optional<BuildingEntity> buildingEntity =
                    buildingRepository.findById( createClassroomRequest.getBuilding() );

            if ( buildingEntity.isPresent() ) {
                ClassroomDto classroomDto = new ClassroomDto();
                classroomDto.setName( createClassroomRequest.getName() );
                classroomDto.setBuilding( buildingEntity.get() );
                classroomDto.setCapacity( createClassroomRequest.getCapacity() );
                ClassroomEntity created = classroomRepository.save( modelMapper.map( classroomDto ,
                        ClassroomEntity.class ) );

                return modelMapper.map( created , ClassroomDto.class );
            } else {
                throw new UserServiceException( "Building is NOT found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
        }
    }

    @Override
    public List<ClassroomDayDto> createClassroomDays ( CreateClassroomDayRequest createClassroomDayRequest ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Optional<ClassroomEntity> classroomEntity =
                    classroomRepository.findById( createClassroomDayRequest.getClassroom() );

            if ( classroomEntity.isPresent() ) {
                List<ClassroomDayEntity> classroomDays = new ArrayList<>();

                createClassroomDayRequest.getDayDates().forEach( date -> {
                    ClassroomDayDto classroomDayDto = new ClassroomDayDto();
                    classroomDayDto.setDayDate( date );
                    classroomDayDto.setClassroom( classroomEntity.get() );
                    classroomDays.add( modelMapper.map( classroomDayDto , ClassroomDayEntity.class ) );
                } );
                List<ClassroomDayEntity> createdClassroomDays
                        = classroomDayRepository.saveAll( classroomDays );

                List<ClassroomDayDto> createdDtoList = new ArrayList<>();
                createdClassroomDays.forEach( classroomDayEntity -> {
                    createdDtoList.add( modelMapper.map( classroomDayEntity , ClassroomDayDto.class ) );
                } );

                return createdDtoList;
            } else {
                throw new UserServiceException( "Classroom is NOT found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
        }
    }

    @Override
    public List<TimeSlotDto> createTimeSlots ( CreateTimeSlotRequest createTimeSlotRequest ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Optional<ClassroomDayEntity> classroomDayEntity =
                    classroomDayRepository.findById( createTimeSlotRequest.getClassroomDay() );

            if ( classroomDayEntity.isPresent() ) {
                List<TimeSlotEntity> timeSlots = new ArrayList<>();

                for ( int a = 0 ; a < createTimeSlotRequest.getStartTimeList().size() ; a++ ) {
                    TimeSlotDto timeSlotDto = new TimeSlotDto();
                    timeSlotDto.setStartTime( createTimeSlotRequest.getStartTimeList().get( a ) );
                    timeSlotDto.setEndTime( createTimeSlotRequest.getEndTimeList().get( a ) );
                    timeSlotDto.setClassroomDay( classroomDayEntity.get() );
                    timeSlots.add( modelMapper.map( timeSlotDto , TimeSlotEntity.class ) );
                }
                List<TimeSlotEntity> createdTimeSlots
                        = timeSlotRepository.saveAll( timeSlots );

                List<TimeSlotDto> createdDtoList = new ArrayList<>();
                createdTimeSlots.forEach( timeSlotEntity -> {
                    createdDtoList.add( modelMapper.map( timeSlotEntity , TimeSlotDto.class ) );
                } );

                return createdDtoList;
            } else {
                throw new UserServiceException( "Classroom is NOT found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( e.getMessage() );
        }
    }

    @Override
    public Boolean deleteLocationRequests ( List<LocationRequestEntity> locationRequestEntityList ) {
        try {
            locationRequestEntityList.forEach( locationRequestEntity -> {
                locationRequestTimeSlotRepository.deleteAll( locationRequestEntity.getLocationRequestTimeSlots() );
            } );

            locationRequestRepository.deleteAll( locationRequestEntityList );

            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    @Override
    public Boolean respondLocationRequest ( long requestId , boolean status ) {
        try {
            Optional<LocationRequestEntity> optional = locationRequestRepository.findById( requestId );

            if ( optional.isPresent() ) {
                optional.get().setAnswered( true );
                optional.get().setConfirmed( status );
                locationRequestRepository.save( optional.get() );
                return true;
            } else {
                return false;
            }
        } catch ( Exception e ) {
            return false;
        }
    }
}
