package com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel;

public class BasicEventParticipantResponse {

    private long id;
    private Boolean isAttended;
    private BasicUserResponse user;
    private Boolean pointGiven;
    private int point;


    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public Boolean getAttended () {
        return isAttended;
    }

    public void setAttended ( Boolean attended ) {
        isAttended = attended;
    }

    public BasicUserResponse getUser () {
        return user;
    }

    public void setUser ( BasicUserResponse user ) {
        this.user = user;
    }

    public int getPoint () {
        return point;
    }

    public void setPoint ( int point ) {
        this.point = point;
    }

    public Boolean getPointGiven () {
        return pointGiven;
    }

    public void setPointGiven ( Boolean pointGiven ) {
        this.pointGiven = pointGiven;
    }
}
