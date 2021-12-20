package com.jack_the_coder.bilboard_backend.model.requestModel;

import java.util.Date;
import java.util.List;

public class CreateClassroomDayRequest {

    private List<Date> dayDates;
    private long classroom;

    public List<Date> getDayDates () {
        return dayDates;
    }

    public void setDayDates ( List<Date> dayDates ) {
        this.dayDates = dayDates;
    }

    public long getClassroom () {
        return classroom;
    }

    public void setClassroom ( long classroom ) {
        this.classroom = classroom;
    }
}
