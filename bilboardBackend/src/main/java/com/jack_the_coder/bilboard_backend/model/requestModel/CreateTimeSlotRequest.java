package com.jack_the_coder.bilboard_backend.model.requestModel;

import java.util.Date;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to create a time slot
 * @implNote DONE
 * @since 05.12.2021
 */
public class CreateTimeSlotRequest {

    private List<Date> startTimeList;
    private List<Date> endTimeList;
    private long classroomDay;

    public List<Date> getStartTimeList () {
        return startTimeList;
    }

    public void setStartTimeList ( List<Date> startTimeList ) {
        this.startTimeList = startTimeList;
    }

    public List<Date> getEndTimeList () {
        return endTimeList;
    }

    public void setEndTimeList ( List<Date> endTimeList ) {
        this.endTimeList = endTimeList;
    }

    public long getClassroomDay () {
        return classroomDay;
    }

    public void setClassroomDay ( long classroomDay ) {
        this.classroomDay = classroomDay;
    }
}
