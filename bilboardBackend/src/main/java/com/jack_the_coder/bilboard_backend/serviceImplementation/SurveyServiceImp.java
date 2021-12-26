package com.jack_the_coder.bilboard_backend.serviceImplementation;

import com.jack_the_coder.bilboard_backend.exception.UserServiceException;
import com.jack_the_coder.bilboard_backend.io.entity.SurveyChoiceEntity;
import com.jack_the_coder.bilboard_backend.io.entity.SurveyEntity;
import com.jack_the_coder.bilboard_backend.io.entity.SurveyParticipantEntity;
import com.jack_the_coder.bilboard_backend.io.entity.SurveyQuestionEntity;
import com.jack_the_coder.bilboard_backend.io.repository.*;
import com.jack_the_coder.bilboard_backend.model.requestModel.VoteRequest;
import com.jack_the_coder.bilboard_backend.service.SurveyService;
import com.jack_the_coder.bilboard_backend.shared.dto.SurveyChoiceDto;
import com.jack_the_coder.bilboard_backend.shared.dto.SurveyDto;
import com.jack_the_coder.bilboard_backend.shared.dto.SurveyParticipantDto;
import com.jack_the_coder.bilboard_backend.shared.dto.SurveyQuestionDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Hacı Çakın
 * @apiNote This class enables communication between controller and repository
 * @since 10.12.2021
 */
@Service
public class SurveyServiceImp implements SurveyService {

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    SurveyQuestionRepository surveyQuestionRepository;

    @Autowired
    SurveyChoiceRepository surveyChoiceRepository;

    @Autowired
    SurveyParticipantRepository surveyParticipantRepository;

    /**
     * Method for creating a survey
     * @param surveyDto is a SurveyDto
     * @param point is a int
     * @return SurveyDto
     * @apiNote Method for creating a survey
     */
    @Override
    public SurveyDto createSurvey ( SurveyDto surveyDto , int point ) {
        ModelMapper modelMapper = new ModelMapper();

        SurveyEntity surveyEntity = modelMapper.map( surveyDto , SurveyEntity.class );
        SurveyEntity created = surveyRepository.save( surveyEntity );

        List<SurveyQuestionDto> surveyQuestionDtoList = new ArrayList<>();

        created.getQuestions().forEach( surveyQuestionEntity -> {
            SurveyQuestionDto surveyQuestionDto = modelMapper.map( surveyQuestionEntity , SurveyQuestionDto.class );
            surveyQuestionDto.setSurvey( created );
            surveyQuestionDtoList.add( surveyQuestionDto );
        } );

        List<SurveyQuestionEntity> createdQuestionEntity = new ArrayList<>();
        createQuestions( surveyQuestionDtoList ).forEach( surveyQuestionDto -> {
            createdQuestionEntity.add( modelMapper.map( surveyQuestionDto , SurveyQuestionEntity.class ) );
        } );

        created.setQuestions( createdQuestionEntity );
        createParticipants( modelMapper.map( created , SurveyDto.class ) , point );

        return modelMapper.map( created , SurveyDto.class );
    }

    /**
     * Method for creating questions
     * @param surveyQuestionDtoList is a List<SurveyQuestionDto>
     * @return List<SurveyQuestionDto>
     * @apiNote Method for creating questions
     */
    @Override
    public List<SurveyQuestionDto> createQuestions ( List<SurveyQuestionDto> surveyQuestionDtoList ) {
        ModelMapper modelMapper = new ModelMapper();

        List<SurveyQuestionEntity> surveyQuestionEntityList = new ArrayList<>();

        surveyQuestionDtoList.forEach( surveyQuestionDto -> {
            surveyQuestionEntityList.add( modelMapper.map( surveyQuestionDto , SurveyQuestionEntity.class ) );
        } );
        List<SurveyQuestionEntity> createdEntityList = surveyQuestionRepository.saveAll( surveyQuestionEntityList );


        createdEntityList.forEach( surveyQuestionEntity -> {
            List<SurveyChoiceDto> surveyChoiceDtoList = new ArrayList<>();

            surveyQuestionEntity.getChoices().forEach( surveyChoiceEntity -> {
                SurveyChoiceDto surveyChoiceDto = modelMapper.map( surveyChoiceEntity , SurveyChoiceDto.class );
                surveyChoiceDto.setQuestion( surveyQuestionEntity );
                surveyChoiceDtoList.add( surveyChoiceDto );
            } );

            List<SurveyChoiceEntity> createdSurveyChoiceList = new ArrayList<>();
            createChoices( surveyChoiceDtoList ).forEach( surveyChoiceDto -> {
                createdSurveyChoiceList.add( modelMapper.map( surveyChoiceDto , SurveyChoiceEntity.class ) );
            } );
            surveyQuestionEntity.setChoices( createdSurveyChoiceList );
        } );

        List<SurveyQuestionDto> createdDtoList = new ArrayList<>();

        createdEntityList.forEach( surveyQuestionEntity -> {
            createdDtoList.add( modelMapper.map( surveyQuestionEntity , SurveyQuestionDto.class ) );
        } );

        return createdDtoList;
    }

    /**
     * Method for creating choices
     * @param surveyChoiceDtoList is a List<SurveyChoiceDto>
     * @return List<SurveyChoiceDto>
     * @apiNote Method for creating choices
     */
    @Override
    public List<SurveyChoiceDto> createChoices ( List<SurveyChoiceDto> surveyChoiceDtoList ) {
        ModelMapper modelMapper = new ModelMapper();

        List<SurveyChoiceEntity> surveyChoiceEntityList = new ArrayList<>();

        surveyChoiceDtoList.forEach( surveyChoiceDto -> {
            surveyChoiceEntityList.add( modelMapper.map( surveyChoiceDto , SurveyChoiceEntity.class ) );
        } );

        List<SurveyChoiceEntity> created = surveyChoiceRepository.saveAll( surveyChoiceEntityList );

        List<SurveyChoiceDto> returnList = new ArrayList<>();

        created.forEach( surveyChoiceEntity -> {
            returnList.add( modelMapper.map( surveyChoiceEntity , SurveyChoiceDto.class ) );
        } );

        return returnList;
    }

    /**
     * Method for creating participants
     * @param surveyDto is a SurveyDto
     * @param point is a int
     * @return List<SurveyParticipantDto>
     * @apiNote Method for creating participants
     */
    @Override
    public List<SurveyParticipantDto> createParticipants ( SurveyDto surveyDto , int point ) {
        AtomicBoolean isPresidentExist = new AtomicBoolean(false);
        AtomicBoolean isAdvisorExist = new AtomicBoolean(false);
        ModelMapper modelMapper = new ModelMapper();
        List<SurveyParticipantDto> surveyParticipantDtoList = new ArrayList<>();

        if ( surveyDto.getForActiveMembers() ) {
            surveyDto.getClub().getClubMembers().forEach( clubMemberEntity -> {
                if(clubMemberEntity.getUser().getId() == surveyDto.getClub().getPresident().getId()){
                    isPresidentExist.set(true);
                }
                if(clubMemberEntity.getUser().getId() == surveyDto.getClub().getAdvisor().getId()){
                    isAdvisorExist.set(true);
                }
                if ( clubMemberEntity.getGePoint() >= point ) {
                    SurveyParticipantDto surveyParticipantDto = new SurveyParticipantDto();
                    surveyParticipantDto.setSurvey( modelMapper.map( surveyDto , SurveyEntity.class ) );
                    surveyParticipantDto.setVoted( false );
                    surveyParticipantDto.setUser( clubMemberEntity.getUser() );
                    surveyParticipantDtoList.add( surveyParticipantDto );
                }
            } );
        } else{
            surveyDto.getClub().getClubMembers().forEach( clubMemberEntity -> {
                if(clubMemberEntity.getUser().getId() == surveyDto.getClub().getPresident().getId()){
                    isPresidentExist.set(true);
                }
                if(clubMemberEntity.getUser().getId() == surveyDto.getClub().getAdvisor().getId()){
                    isAdvisorExist.set(true);
                }
                SurveyParticipantDto surveyParticipantDto = new SurveyParticipantDto();
                surveyParticipantDto.setSurvey( modelMapper.map( surveyDto , SurveyEntity.class ) );
                surveyParticipantDto.setVoted( false );
                surveyParticipantDto.setUser( clubMemberEntity.getUser() );
                surveyParticipantDtoList.add( surveyParticipantDto );
            } );
        }

        surveyDto.getClub().getClubBoardMembers().forEach( clubBoardMemberEntity -> {
            SurveyParticipantDto surveyParticipantDto = new SurveyParticipantDto();
            surveyParticipantDto.setSurvey( modelMapper.map( surveyDto , SurveyEntity.class ) );
            surveyParticipantDto.setVoted( false );
            surveyParticipantDto.setUser( clubBoardMemberEntity.getUser() );
            surveyParticipantDtoList.add( surveyParticipantDto );
        } );

        if ( surveyDto.getClub().getAdvisor() != null  && !isAdvisorExist.get()) {
            SurveyParticipantDto surveyParticipantDto = new SurveyParticipantDto();
            surveyParticipantDto.setSurvey( modelMapper.map( surveyDto , SurveyEntity.class ) );
            surveyParticipantDto.setVoted( false );
            surveyParticipantDto.setUser( surveyDto.getClub().getAdvisor() );
            surveyParticipantDtoList.add( surveyParticipantDto );
        }

        if ( surveyDto.getClub().getPresident() != null && !isPresidentExist.get()) {
            SurveyParticipantDto surveyParticipantDto = new SurveyParticipantDto();
            surveyParticipantDto.setSurvey( modelMapper.map( surveyDto , SurveyEntity.class ) );
            surveyParticipantDto.setVoted( false );
            surveyParticipantDto.setUser( surveyDto.getClub().getPresident() );
            surveyParticipantDtoList.add( surveyParticipantDto );
        }

        List<SurveyParticipantEntity> surveyParticipantEntityList = new ArrayList<>();
        surveyParticipantDtoList.forEach( surveyParticipantDto -> {
            surveyParticipantEntityList.add( modelMapper.map( surveyParticipantDto , SurveyParticipantEntity.class ) );
        } );

        List<SurveyParticipantDto> createdSurveyParticipantDtoList = new ArrayList<>();
        surveyParticipantRepository.saveAll( surveyParticipantEntityList ).forEach( surveyParticipantEntity -> {
            createdSurveyParticipantDtoList.add( modelMapper.map( surveyParticipantEntity ,
                    SurveyParticipantDto.class ) );
        } );

        return createdSurveyParticipantDtoList;
    }

    /**
     * Method for getting a survey
     * @param surveyId is a long
     * @return SurveyDto
     * @apiNote Method for getting a survey
     */
    @Override
    public SurveyDto getSurvey ( long surveyId ) {
        try {
            Optional<SurveyEntity> optionalSurveyEntity = surveyRepository.findById( surveyId );
            if ( optionalSurveyEntity.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();

                return modelMapper.map( optionalSurveyEntity.get() , SurveyDto.class );
            } else {
                throw new UserServiceException( "Survey is not found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    /**
     * Method for getting a survey participant
     * @param participantId is a long
     * @return SurveyParticipantDto
     * @apiNote Method for getting a survey participant
     */
    @Override
    public SurveyParticipantDto getSurveyParticipant ( long participantId ) {
        try {
            Optional<SurveyParticipantEntity> optionalSurveyParticipantEntity =
                    surveyParticipantRepository.findById( participantId );
            if ( optionalSurveyParticipantEntity.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();

                return modelMapper.map( optionalSurveyParticipantEntity.get() , SurveyParticipantDto.class );
            } else {
                throw new UserServiceException( "Participant is not found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    /**
     * Method for getting a survey choice
     * @param surveyChoiceId is a long
     * @return SurveyChoiceDto
     * @apiNote Method for getting a survey choice
     */
    @Override
    public SurveyChoiceDto getSurveyChoice ( long surveyChoiceId ) {
        try {
            Optional<SurveyChoiceEntity> optionalSurveyChoiceEntity =
                    surveyChoiceRepository.findById( surveyChoiceId );
            if ( optionalSurveyChoiceEntity.isPresent() ) {
                ModelMapper modelMapper = new ModelMapper();

                return modelMapper.map( optionalSurveyChoiceEntity.get() , SurveyChoiceDto.class );
            } else {
                throw new UserServiceException( "Choice is not found!" );
            }
        } catch ( Exception e ) {
            throw new UserServiceException( "Something went wrong!" );
        }
    }

    /**
     * Method for voting to a survey
     * @param voteRequest is a VoteRequest
     * @return Boolean
     * @apiNote Method for voting to a survey
     */
    @Override
    public Boolean voteSurvey ( VoteRequest voteRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        SurveyDto surveyDto = getSurvey( voteRequest.getSurvey() );

        SurveyParticipantDto surveyParticipantDto = getSurveyParticipant( voteRequest.getUser() );

        if ( surveyDto.getStartDate().before( new Date() ) && surveyDto.getEndDate().after( new Date() ) &&
                surveyDto.getStatus().name().equals( "active" ) && !surveyParticipantDto.getVoted() ) {

            List<SurveyChoiceEntity> surveyChoiceEntityList = new ArrayList<>();

            voteRequest.getChoices().forEach( aLong -> {
                SurveyChoiceDto surveyChoiceDto = getSurveyChoice( aLong );
                surveyChoiceDto.setVoteCount( surveyChoiceDto.getVoteCount() + 1 );
                surveyChoiceEntityList.add( modelMapper.map( surveyChoiceDto , SurveyChoiceEntity.class ) );
            } );

            surveyChoiceRepository.saveAll( surveyChoiceEntityList );


            surveyParticipantDto.setVoted( true );
            surveyParticipantRepository.save( modelMapper.map( surveyParticipantDto , SurveyParticipantEntity.class ) );
            return true;

        } else {
            return false;
        }
    }
}
