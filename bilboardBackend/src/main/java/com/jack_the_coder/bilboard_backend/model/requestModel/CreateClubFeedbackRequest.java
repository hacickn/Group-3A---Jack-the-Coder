package com.jack_the_coder.bilboard_backend.model.requestModel;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to create a club feedback
 * @implNote DONE
 * @since 05.12.2021
 */
public class CreateClubFeedbackRequest {
    private String content;
    private long club;
    private long user;

    /**
     * get content method
     * @return content is String
     */
    public String getContent () {
        return content;
    }

    public void setContent ( String content ) {
        this.content = content;
    }

    /**
     * get club method
     * @return club is long
     */
    public long getClub () {
        return club;
    }

    public void setClub ( long club ) {
        this.club = club;
    }

    /**
     * get user method
     * @return user is long
     */
    public long getUser () {
        return user;
    }

    public void setUser ( long user ) {
        this.user = user;
    }
}
