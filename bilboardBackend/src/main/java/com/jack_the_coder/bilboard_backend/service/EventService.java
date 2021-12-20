package com.jack_the_coder.bilboard_backend.service;

import com.jack_the_coder.bilboard_backend.shared.dto.EventDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface EventService {

    EventDto getEvent ( long eventId );

    EventDto createEvent ( MultipartFile eventPhoto , String title , String duration , String description , Date date ,
                           Boolean isOnline , Boolean isVisible , String location , int maxParticipationCount ,
                           int gePoint , Boolean restrictionForMember , List<Long> timeSlotIdList , long clubId );
}
