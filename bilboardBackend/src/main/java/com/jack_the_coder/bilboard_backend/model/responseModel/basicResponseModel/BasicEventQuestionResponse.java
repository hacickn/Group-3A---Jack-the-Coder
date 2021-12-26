package com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel;

import java.util.Date;

/**
 * @author Aslı Dinç
 * @apiNote This class is a response to client
 * @implNote DONE
 * @since 05.12.2021
 */
public class BasicEventQuestionResponse {

    private long id;
    private String question;
    private String answer;
    private Date date;
    private BasicUserResponse userResponse;

    /**
     * Get id method
     * @return long
     */
    public long getId () {
        return id;
    }

    /**
     * set id method
     * @param id is a long parameter
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
     * @param question is a String
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
     * @param answer is a String
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
     * @param date is a Date
     */
    public void setDate ( Date date ) {
        this.date = date;
    }

    /**
     * Get userResponse method
     * @return BasicUserResponse instance
     */
    public BasicUserResponse getUserResponse () {
        return userResponse;
    }

    /**
     * Set userResponse method
     * @param userResponse is a BasicUserResponse instance
     */
    public void setUserResponse (
            BasicUserResponse userResponse ) {
        this.userResponse = userResponse;
    }
}
