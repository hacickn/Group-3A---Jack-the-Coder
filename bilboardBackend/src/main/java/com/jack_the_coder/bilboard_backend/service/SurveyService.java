package com.jack_the_coder.bilboard_backend.service;

import com.jack_the_coder.bilboard_backend.model.requestModel.VoteRequest;
import com.jack_the_coder.bilboard_backend.shared.dto.SurveyChoiceDto;
import com.jack_the_coder.bilboard_backend.shared.dto.SurveyDto;
import com.jack_the_coder.bilboard_backend.shared.dto.SurveyParticipantDto;
import com.jack_the_coder.bilboard_backend.shared.dto.SurveyQuestionDto;

import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This class enables communication between controller and repository
 * @since 10.12.2021
 */
public interface SurveyService {

    SurveyDto createSurvey ( SurveyDto surveyDto , int point );

    SurveyDto getSurvey ( long surveyId );

    SurveyParticipantDto getSurveyParticipant ( long participantId );

    SurveyChoiceDto getSurveyChoice ( long surveyChoiceId );

    List<SurveyQuestionDto> createQuestions ( List<SurveyQuestionDto> surveyQuestionDtoList );

    List<SurveyChoiceDto> createChoices ( List<SurveyChoiceDto> surveyChoiceDtoList );

    List<SurveyParticipantDto> createParticipants ( SurveyDto surveyDto , int point );

    Boolean voteSurvey ( VoteRequest voteRequest );


}
