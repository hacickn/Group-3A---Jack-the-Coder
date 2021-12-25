package com.jack_the_coder.bilboard_backend.service;

import com.jack_the_coder.bilboard_backend.io.entity.EventEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;
import com.jack_the_coder.bilboard_backend.shared.dto.EventDto;
import com.jack_the_coder.bilboard_backend.shared.dto.EventParticipantDto;
import com.jack_the_coder.bilboard_backend.shared.dto.EventQuestionDto;
import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface EventService {

    EventDto getEvent ( long eventId );

    EventDto createEvent ( MultipartFile eventPhoto , String title , String duration , String description , Date date ,
                           Boolean isOnline , Boolean isVisible , String location , int maxParticipationCount ,
                           int gePoint , Boolean restrictionForMember , List<Long> timeSlotIdList , long clubId );

    List<EventDto> getDiscover ();

    EventDto getEventById ( long id );

    EventQuestionDto getQuestionById ( long eventQuestionId );

    EventParticipantDto getEventParticipantById ( long eventParticipantId );

    EventParticipantDto getEventParticipantByUserAndEvent ( UserEntity userEntity , EventEntity eventEntity);

    Boolean deleteEvent ( EventDto eventDto );

    Boolean enrollToEvent ( EventDto eventDto , UserDto userDto );

    Boolean attendToEvent ( EventDto eventDto , UserDto userDto );

    String createEventCode ( EventDto eventDto );

    Boolean givePointToEvent ( EventDto eventDto , UserDto userDto , int point );

    Boolean askQuestion ( EventDto eventDto , String question , UserDto userDto );

    Boolean respondToQuestion ( EventQuestionDto eventQuestionDto , String answer );
}
