package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın, Aslı Dinç
 * @apiNote This class is base structure of the surveys table in database
 * @implNote DONE
 * @since 09.11.2021
 */
@Entity( name = "surveys" )
public class SurveyEntity implements Serializable {

    public enum SurveyStatus {
        active,
        not_active,
        done
    }

    private static final long serialVersionUID = -3256397832358851326L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "title", length = 100, nullable = false )
    private String title;

    @Column( name = "photo", length = 100 )
    private String photo;

    @Column( name = "start_date", nullable = false )
    private Date startDate;

    @Column( name = "end_date", nullable = false )
    private Date endDate;

    @Enumerated( EnumType.STRING )
    @Column( name = "status" )
    private SurveyStatus status;

    @Column( name = "for_active_members" )
    private Boolean forActiveMembers;

    @OneToMany( targetEntity = SurveyQuestionEntity.class, mappedBy = "survey" )
    private List<SurveyQuestionEntity> questions;

    @ManyToOne( targetEntity = ClubEntity.class )
    @JoinColumn( name = "club" )
    private ClubEntity club;

    @OneToMany( targetEntity = SurveyParticipantEntity.class, mappedBy = "survey" )
    private List<SurveyParticipantEntity> surveyParticipants;

    /**
     * get id method
     * @return id is a long
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
     * get title method
     * @return title is String
     */
    public String getTitle () {
        return title;
    }

    /**
     * set title method
     * @param title is String
     */
    public void setTitle ( String title ) {
        this.title = title;
    }

    /**
     * get photo method
     * @return photo is String
     */
    public String getPhoto () {
        return photo;
    }

    /**
     * set photo method
     * @param photo is String
     */
    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    /**
     * get start date method
     * @return startDate is Date
     */
    public Date getStartDate () {
        return startDate;
    }

    /**
     * set start date method
     * @param startDate is Date
     */
    public void setStartDate ( Date startDate ) {
        this.startDate = startDate;
    }

    /**
     * get end date method
     * @return endDate is Date
     */
    public Date getEndDate () {
        return endDate;
    }

    /**
     * set end date method
     * @param endDate is Date
     */
    public void setEndDate ( Date endDate ) {
        this.endDate = endDate;
    }

    /**
     * get status method
     * @return status is SurveyStatus
     */
    public SurveyStatus getStatus () {
        return status;
    }

    /**
     * set status method
     * @param status is SurveyStatus
     */
    public void setStatus ( SurveyStatus status ) {
        this.status = status;
    }

    /**
     * get for active members method
     * @return isForActiveMembers is Boolean
     */
    public Boolean getForActiveMembers () {
        return forActiveMembers;
    }

    /**
     * set for active members method
     * @param forActiveMembers is Boolean
     */
    public void setForActiveMembers ( Boolean forActiveMembers ) {
        this.forActiveMembers = forActiveMembers;
    }

    /**
     * get questions method
     * @return questions is SurveyQuestionEntity list
     */
    public List<SurveyQuestionEntity> getQuestions () {
        return questions;
    }

    /**
     * set questions method
     * @param questions is SurveyQuestionEntity list
     */
    public void setQuestions ( List<SurveyQuestionEntity> questions ) {
        this.questions = questions;
    }

    /**
     * get club method
     * @return club is ClubEntity
     */
    public ClubEntity getClub () {
        return club;
    }

    /**
     * set club method
     * @param club is ClubEntity
     */
    public void setClub ( ClubEntity club ) {
        this.club = club;
    }

    /**
     * get survey participants method
     * @return surveyParticipants is SurveyParticipantEntity list
     */
    public List<SurveyParticipantEntity> getSurveyParticipants () {
        return surveyParticipants;
    }

    /**
     * set survey participants method
     * @param surveyParticipants is SurveyParticipantEntity list
     */
    public void setSurveyParticipants (
            List<SurveyParticipantEntity> surveyParticipants ) {
        this.surveyParticipants = surveyParticipants;
    }
}
