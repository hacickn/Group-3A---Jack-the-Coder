package com.jack_the_coder.bilboard_backend.model.responseModel;

import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicEventResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicUserResponse;

import java.util.Date;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class EventQuestionResponse {

    private long id;
    private String question;
    private String answer;
    private Date date;
    private BasicUserResponse userResponse;
    private BasicEventResponse event;

    /**
     * Get id method
     * @return long
     */
    public long getId () {
        return id;
    }

    /**
     * Set id method
     * @param id is an long parameter
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Get question method
     * @return String
     */
    public String getQuestion () {
        return question;
    }

    /**
     * Set question method
     * @param question is String
     */
    public void setQuestion ( String question ) {
        this.question = question;
    }

    /**
     * Get answer method
     * @return String
     */
    public String getAnswer () {
        return answer;
    }

    /**
     * Set answer method
     * @param answer is String
     */
    public void setAnswer ( String answer ) {
        this.answer = answer;
    }

    /**
     * Get date method
     * @return Date
     */
    public Date getDate () {
        return date;
    }

    /**
     * Set date method
     * @param date is Date
     */
    public void setDate ( Date date ) {
        this.date = date;
    }

    /**
     * Get userResponse method
     * @return BasicUserResponse
     */
    public BasicUserResponse getUserResponse () {
        return userResponse;
    }

    /**
     * Set userResponse method
     * @param userResponse is BasicUserResponse
     */
    public void setUserResponse (
            BasicUserResponse userResponse ) {
        this.userResponse = userResponse;
    }

    /**
     * Get event method
     * @return BasicEventResponse
     */
    public BasicEventResponse getEvent () {
        return event;
    }

    /**
     * Set event method
     * @param event is BasicEventResponse
     */
    public void setEvent ( BasicEventResponse event ) {
        this.event = event;
    }
}
