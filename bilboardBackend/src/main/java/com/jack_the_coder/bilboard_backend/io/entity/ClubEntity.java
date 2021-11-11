package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This class is base structure of the clubs in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 11.11.2021
 */
@Entity( name = "clubs" )
public class ClubEntity implements Serializable {

    private static final long serialVersionUID = -3993241986569285225L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    private String name;

    private String shortName;

    private String wpLink;

    private String instaLink;

    private String photo;

    //  todo oneToMany =>  clubFeedbacks, clubSponsorships,

    @OneToOne( targetEntity = UserEntity.class, mappedBy = "presidentOf" )
    private UserEntity president;

    @OneToOne( targetEntity = UserEntity.class, mappedBy = "advisorOf" )
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
}
