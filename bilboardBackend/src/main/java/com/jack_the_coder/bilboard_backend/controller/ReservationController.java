package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.model.requestModel.CreateBuildingRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateClassroomDayRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateClassroomRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateTimeSlotRequest;
import com.jack_the_coder.bilboard_backend.model.responseModel.BuildingResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.ClassroomDayResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.ClassroomResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.TimeSlotResponse;
import com.jack_the_coder.bilboard_backend.service.ReservationService;
import com.jack_the_coder.bilboard_backend.shared.dto.BuildingDto;
import com.jack_the_coder.bilboard_backend.shared.dto.ClassroomDayDto;
import com.jack_the_coder.bilboard_backend.shared.dto.ClassroomDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This is club controller that consists of reservation operations. Client interacts with that router.
 * It's path is /bilboard-app/v1/reservation
 * @implNote DONE
 * @since 11.12.2021
 */
@CrossOrigin
@RestController
@RequestMapping( "/reservation" )
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    /**
     *
     * @param createBuildingRequest is a CreateBuildingRequest
     * @return BuildingResponse
     * @apiNote This method is used to add building.
     */
    @PostMapping( path = "/building" )
    public BuildingResponse createBuilding ( @RequestBody CreateBuildingRequest createBuildingRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        BuildingDto buildingDto = reservationService.createBuilding( createBuildingRequest );
        return modelMapper.map( buildingDto , BuildingResponse.class );
    }

    /**
     *
     * @param CreateClassroomRequest createClassroomRequest
     * @return BuildingResponse
     * @apiNote This method is used to add classroom.
     */
    @PostMapping( path = "/classroom" )
    public ClassroomResponse createClassroom ( @RequestBody CreateClassroomRequest createClassroomRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        ClassroomDto classroomDto = reservationService.createClassroom( createClassroomRequest );
        return modelMapper.map( classroomDto , ClassroomResponse.class );
    }

    /**
     * @param CreateClassroomDayRequest createClassroomDayRequest
     * @return List<ClassroomDayResponse>
     * @apiNote This method is used to add classroom day.
     */
    @PostMapping( path = "/classroomDay" )
    public List<ClassroomDayResponse> createClassroomDay (
            @RequestBody CreateClassroomDayRequest createClassroomDayRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        List<ClassroomDayResponse> classroomDayResponseList = new ArrayList<>();

        reservationService.createClassroomDays( createClassroomDayRequest ).forEach( classroomDayDto -> {
            classroomDayResponseList.add( modelMapper.map( classroomDayDto , ClassroomDayResponse.class ) );
        } );

        return classroomDayResponseList;
    }

    /**
     * @param CreateTimeSlotRequest createTimeSlotRequest
     * @return List<TimeSlotResponse>
     * @apiNote This method is used to add time slot.
     */
    @PostMapping( path = "/timeSlot" )
    public List<TimeSlotResponse> createClassroom ( @RequestBody CreateTimeSlotRequest createTimeSlotRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        List<TimeSlotResponse> timeSlotResponseList = new ArrayList<>();

        reservationService.createTimeSlots( createTimeSlotRequest ).forEach( timeSlotDto -> {
            timeSlotResponseList.add( modelMapper.map( timeSlotDto , TimeSlotResponse.class ) );
        } );
        return timeSlotResponseList;
    }
}
