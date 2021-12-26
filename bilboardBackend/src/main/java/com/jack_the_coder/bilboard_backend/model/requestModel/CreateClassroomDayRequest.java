package com.jack_the_coder.bilboard_backend.model.requestModel;

import java.util.Date;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to create a classroom day
 * @implNote DONE
 * @since 05.12.2021
 */
public class CreateClassroomDayRequest {

    private List<Date> dayDates;
    private long classroom;

    /**
     * get dayDates method
     * @return dayDates is List<Date>
     */
    public List<Date> getDayDates () {
        return dayDates;
    }

    /**
     * Set dayDates method
     * @param dayDates is List<Date>
     */
    public void setDayDates ( List<Date> dayDates ) {
        this.dayDates = dayDates;
    }

    /**
     * get classroom method
     * @return classroom is String
     */
    public long getClassroom () {
        return classroom;
    }

    /**
     * Set classroom method
     * @param classroom is long
     */
    public void setClassroom ( long classroom ) {
        this.classroom = classroom;
    }
}
