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

    /**
     * get startTimeList method
     * @return startTimeList is List<Date>
     */
    public List<Date> getStartTimeList () {
        return startTimeList;
    }

    /**
     * Set startTimeList method
     * @param startTimeList is List<Date>
     */
    public void setStartTimeList ( List<Date> startTimeList ) {
        this.startTimeList = startTimeList;
    }

    /**
     * get endTimeList method
     * @return endTimeList is List<Date>
     */
    public List<Date> getEndTimeList () {
        return endTimeList;
    }

    /**
     * Set endTimeList method
     * @param endTimeList is List<Date>
     */
    public void setEndTimeList ( List<Date> endTimeList ) {
        this.endTimeList = endTimeList;
    }

    /**
     * get classroomDay method
     * @return classroomDay is long
     */
    public long getClassroomDay () {
        return classroomDay;
    }

    /**
     * Set classroomDay method
     * @param classroomDay is long
     */
    public void setClassroomDay ( long classroomDay ) {
        this.classroomDay = classroomDay;
    }
}
