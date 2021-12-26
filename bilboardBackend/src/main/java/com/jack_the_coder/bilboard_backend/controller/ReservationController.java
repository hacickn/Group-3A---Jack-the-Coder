package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.model.OperationName;
import com.jack_the_coder.bilboard_backend.model.OperationStatus;
import com.jack_the_coder.bilboard_backend.model.StatusResponse;
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
import com.jack_the_coder.bilboard_backend.shared.dto.ClassroomDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This is club controller that consists of reservation operations. Client interacts with that router.
 * Its path is /bilboard-app/v1/reservation
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
     * Method for adding a building
     * @param createBuildingRequest is a CreateBuildingRequest instance
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
     *  Method for adding a classroom
     * @param createClassroomRequest is a CreateClassroomRequest instance
     * @return ClassroomResponse
     * @apiNote This method is used to add classroom.
     */
    @PostMapping( path = "/classroom" )
    public ClassroomResponse createClassroom ( @RequestBody CreateClassroomRequest createClassroomRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        ClassroomDto classroomDto = reservationService.createClassroom( createClassroomRequest );
        return modelMapper.map( classroomDto , ClassroomResponse.class );
    }

    /**
     * Method for adding a classroom day
     * @param createClassroomDayRequest is a CreateClassroomDayRequest instance
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
     * Method for adding a classroom time slot
     * @param createTimeSlotRequest is a CreateTimeSlotRequest instance
     * @return List<TimeSlotResponse>
     * @apiNote This method is used to add time slot.
     */
    @PostMapping( path = "/timeSlot" )
    public List<TimeSlotResponse> createClassroomTimeSlot ( @RequestBody CreateTimeSlotRequest createTimeSlotRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        List<TimeSlotResponse> timeSlotResponseList = new ArrayList<>();

        reservationService.createTimeSlots( createTimeSlotRequest ).forEach( timeSlotDto -> {
            timeSlotResponseList.add( modelMapper.map( timeSlotDto , TimeSlotResponse.class ) );
        } );
        return timeSlotResponseList;
    }

    /**
     * Method for assigning a classroom to an event
     * @param requestId is a long
     * @param status is a boolean
     * @return StatusResponse
     * @apiNote This method is used to assign classroom.
     */
    @PostMapping(path = "/respond")
    public StatusResponse assignClassroom(@RequestParam(value = "requestId") long requestId,
                                          @RequestParam(value = "status") boolean status){
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );

        if(reservationService.respondLocationRequest( requestId,status )){
            statusResponse.setOperationName( OperationStatus.SUCCESS.name() );
        }else{
            statusResponse.setOperationName( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }



}
