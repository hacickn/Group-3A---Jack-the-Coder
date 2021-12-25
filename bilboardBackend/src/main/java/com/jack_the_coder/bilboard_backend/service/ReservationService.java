package com.jack_the_coder.bilboard_backend.service;

import com.jack_the_coder.bilboard_backend.io.entity.EventEntity;
import com.jack_the_coder.bilboard_backend.io.entity.LocationRequestEntity;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateBuildingRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateClassroomDayRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateClassroomRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateTimeSlotRequest;
import com.jack_the_coder.bilboard_backend.model.responseModel.ClassroomDayResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.ClassroomResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.TimeSlotResponse;
import com.jack_the_coder.bilboard_backend.shared.dto.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReservationService {

    LocationRequestDto createLocationRequest ( List<Long> timeSlotIdList , EventEntity eventEntity );

    BuildingDto createBuilding ( CreateBuildingRequest createBuildingRequest );

    ClassroomDto createClassroom ( CreateClassroomRequest createClassroomRequest );

    List<ClassroomDayDto> createClassroomDays ( CreateClassroomDayRequest createClassroomDayRequest );

    List<TimeSlotDto> createTimeSlots ( CreateTimeSlotRequest createTimeSlotRequest );

    Boolean deleteLocationRequests(List<LocationRequestEntity> locationRequestEntityList);
}
