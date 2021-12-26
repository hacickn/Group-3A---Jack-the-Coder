package com.jack_the_coder.bilboard_backend.controller;


import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.model.OperationName;
import com.jack_the_coder.bilboard_backend.model.OperationStatus;
import com.jack_the_coder.bilboard_backend.model.StatusResponse;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateSurveyRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.VoteRequest;
import com.jack_the_coder.bilboard_backend.model.responseModel.SurveyResponse;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.service.SurveyService;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubDto;
import com.jack_the_coder.bilboard_backend.shared.dto.SurveyDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hacı Çakın
 * @apiNote This is club controller that consists of survey operations. Client interacts with that router.
 * Its path is /bilboard-app/v1/survey
 * @implNote DONE
 * @since 11.12.2021
 */
@CrossOrigin
@RestController
@RequestMapping( "/survey" )
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @Autowired
    ClubService clubService;

    /**
     * Method for getting the surveys
     * @param surveyId is a long
     * @return SurveyResponse
     * @apiNote This method is used to get survey.
     */
    @GetMapping
    public SurveyResponse getSurvey ( @RequestParam( value = "surveyId" ) long surveyId ) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map( surveyService.getSurvey( surveyId ) , SurveyResponse.class );
    }

    /**
     * Method for creating a survey
     * @param createSurveyRequest is a CreateSurveyRequest instance
     * @return SurveyResponse
     * @apiNote This method is used to create survey.
     */
    @PostMapping
    public SurveyResponse createSurvey ( @RequestBody CreateSurveyRequest createSurveyRequest ) {
        ModelMapper modelMapper = new ModelMapper();

        ClubDto clubDto = clubService.getClubById( createSurveyRequest.getClub() );
        SurveyDto surveyDto = modelMapper.map( createSurveyRequest , SurveyDto.class );
        surveyDto.setClub( modelMapper.map( clubDto , ClubEntity.class ) );
        SurveyDto createdDto = surveyService.createSurvey( surveyDto , createSurveyRequest.getPoint() );
        return modelMapper.map( createdDto , SurveyResponse.class );
    }

    /**
     * Method for voting a survey
     * @param voteRequest is a VoteRequest instance
     * @return StatusResponse
     * @apiNote This method is used to vote for survey.
     */
    @PostMapping(path = "/vote")
    public StatusResponse voteSurvey ( @RequestBody VoteRequest voteRequest ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );

        if ( surveyService.voteSurvey( voteRequest ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }
        return statusResponse;
    }

}
