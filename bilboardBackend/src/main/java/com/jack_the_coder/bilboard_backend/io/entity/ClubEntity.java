package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Hacı Çakın and Aslı Dinç
 * @apiNote This class is base structure of the clubs in database
 * @implNote DONE
 * @since 11.11.2021
 */
@Entity( name = "clubs" )
public class ClubEntity implements Serializable {

    private static final long serialVersionUID = -3993241986569285225L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "name", length = 45, nullable = false )
    private String name;

    @Column( name = "short_name", length = 45, nullable = false )
    private String shortName;

    @Column( name = "wp_link", length = 45 )
    private String wpLink;

    @Column( name = "insta_link", length = 45 )
    private String instaLink;

    @Column( name = "photo", length = 45 )
    private String photo;

    @OneToOne( targetEntity = UserEntity.class )
    private UserEntity president;

    @OneToOne( targetEntity = UserEntity.class )
    private UserEntity advisor;

    @OneToMany( targetEntity = ClubMemberEntity.class, mappedBy = "club" )
    private List<ClubMemberEntity> clubMembers;

    @OneToMany( targetEntity = ClubBoardMemberEntity.class, mappedBy = "club" )
    private List<ClubBoardMemberEntity> clubBoardMembers;

    @OneToMany( targetEntity = EventEntity.class, mappedBy = "club" )
    private List<EventEntity> events;

    @OneToMany( targetEntity = SurveyEntity.class, mappedBy = "club" )
    private List<SurveyEntity> surveys;

    @ManyToOne( targetEntity = UniversityEntity.class )
    @JoinColumn( name = "university" )
    private UniversityEntity university;

    @OneToMany( targetEntity = ClubFeedbackEntity.class, mappedBy = "club" )
    private List<ClubFeedbackEntity> clubFeedbacks;

    @OneToMany( targetEntity = ClubSponsorshipEntity.class, mappedBy = "club" )
    private List<ClubSponsorshipEntity> clubSponsorships;

    @OneToMany( targetEntity = EnrollRequestEntity.class, mappedBy = "club" )
    private List<EnrollRequestEntity> enrollRequests;

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
     * Get name method
     * @return String
     */
    public String getName () {
        return name;
    }

    /**
     * Set name method
     * @param name is String
     */
    public void setName ( String name ) {
        this.name = name;
    }

    /**
     * Get short name method
     * @return String
     */
    public String getShortName () {
        return shortName;
    }

    /**
     * Set short name method
     * @param shortName is String
     */
    public void setShortName ( String shortName ) {
        this.shortName = shortName;
    }

    /**
     * Get whatsapp link method
     * @return String
     */
    public String getWpLink () {
        return wpLink;
    }

    /**
     * Set whatsapp link method
     * @param wpLink is String
     */
    public void setWpLink ( String wpLink ) {
        this.wpLink = wpLink;
    }

    /**
     * Get instagram link method
     * @return String
     */
    public String getInstaLink () {
        return instaLink;
    }

    /**
     * Set instagram link method
     * @param instaLink is String
     */
    public void setInstaLink ( String instaLink ) {
        this.instaLink = instaLink;
    }

    /**
     * Get photo method
     * @return String
     */
    public String getPhoto () {
        return photo;
    }

    /**
     * Set photo method
     * @param photo is String
     */
    public void setPhoto ( String photo ) {
        this.photo = photo;
    }

    /**
     * Get president method
     * @return UserEntity object
     */
    public UserEntity getPresident () {
        return president;
    }

    /**
     * Set president method
     * @param president is UserEntity
     */
    public void setPresident ( UserEntity president ) {
        this.president = president;
    }

    /**
     * Get advisor method
     * @return UserEntity object
     */
    public UserEntity getAdvisor () {
        return advisor;
    }

    /**
     * Set advisor method
     * @param advisor is UserEntity
     */
    public void setAdvisor ( UserEntity advisor ) {
        this.advisor = advisor;
    }

    /**
     * Get club members method
     * @return ClubMemberEntity list
     */
    public List<ClubMemberEntity> getClubMembers () {
        return clubMembers;
    }

    /**
     * Set club members method
     * @param clubMembers is ClubMemberEntity list
     */
    public void setClubMembers ( List<ClubMemberEntity> clubMembers ) {
        this.clubMembers = clubMembers;
    }

    /**
     * Get club board members method
     * @return ClubBoardMemberEntity list
     */
    public List<ClubBoardMemberEntity> getClubBoardMembers () {
        return clubBoardMembers;
    }

    /**
     * Set club members method
     * @param clubBoardMembers is ClubBoardMemberEntity list
     */
    public void setClubBoardMembers (
            List<ClubBoardMemberEntity> clubBoardMembers ) {
        this.clubBoardMembers = clubBoardMembers;
    }

    /**
     * Get events method
     * @return EventEntity list
     */
    public List<EventEntity> getEvents () {
        return events;
    }

    /**
     * Set events method
     * @param events is EventEntity list
     */
    public void setEvents ( List<EventEntity> events ) {
        this.events = events;
    }

    /**
     * Get surveys method
     * @return SurveyEntity list
     */
    public List<SurveyEntity> getSurveys () {
        return surveys;
    }

    /**
     * Set surveys method
     * @param surveys is SurveyEntity list
     */
    public void setSurveys ( List<SurveyEntity> surveys ) {
        this.surveys = surveys;
    }

    /**
     * Get university method
     * @return UniversityEntity
     */
    public UniversityEntity getUniversity () {
        return university;
    }

    /**
     * Set university method
     * @param university is UniversityEntity
     */
    public void setUniversity ( UniversityEntity university ) {
        this.university = university;
    }

    /**
     * Get club feedbacks method
     * @return ClubFeedbackEntity list
     */
    public List<ClubFeedbackEntity> getClubFeedbacks () {
        return clubFeedbacks;
    }

    /**
     * Set club feedbacks method
     * @param clubFeedbacks is ClubFeedbackEntity list
     */
    public void setClubFeedbacks (
            List<ClubFeedbackEntity> clubFeedbacks ) {
        this.clubFeedbacks = clubFeedbacks;
    }

    /**
     * Get club sponsorships method
     * @return ClubSponsorshipEntity list
     */
    public List<ClubSponsorshipEntity> getClubSponsorships () {
        return clubSponsorships;
    }

    /**
     * Set club sponsorships method
     * @param clubSponsorships is ClubSponsorshipEntity list
     */
    public void setClubSponsorships (
            List<ClubSponsorshipEntity> clubSponsorships ) {
        this.clubSponsorships = clubSponsorships;
    }

    /**
     * Get enroll requests method
     * @return ClubSponsorshipEntity list
     */
    public List<EnrollRequestEntity> getEnrollRequests () {
        return enrollRequests;
    }

    /**
     * Set enroll requests method
     * @param enrollRequests is EnrollRequestEntity list
     */
    public void setEnrollRequests (
            List<EnrollRequestEntity> enrollRequests ) {
        this.enrollRequests = enrollRequests;
    }
}
