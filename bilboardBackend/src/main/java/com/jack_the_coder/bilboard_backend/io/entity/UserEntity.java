package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın, Aslı Dinç
 * @apiNote This class is base structure of the users table in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 09.11.2021
 */
@Entity( name = "users" )
public class UserEntity implements Serializable {

    public enum UserTypes {
        student,
        academic,
        admin,
        administrativeAssistants,
    }

    private static final long serialVersionUID = 8585888063588545565L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id" )
    private long id;

    @Column( nullable = false, length = 50, name = "name" )
    private String name;

    @Column( nullable = false, length = 50, name = "surname" )
    private String surname;

    @Enumerated( EnumType.STRING )
    @Column( name = "type" )
    private UserTypes type;

    @Column( length = 80, name = "password", nullable = false )
    private String password;

    @Column( length = 20, name = "bilkent_ID", nullable = false )
    private String bilkentId;

    @Column( nullable = false, length = 120, unique = true, name = "email" )
    private String email;

    @Column( name = "email_confirmation" )
    private boolean emailConfirmation;

    @Column( name = "email_confirmation_token" )
    private String emailConfirmationToken;

    @Column( name = "jwt_expiration" )
    private Date jwtExpirationTime;

    // todo one-to-many => eventParticipants, surveyParticipants, clubFeedbacks, eventQuestions,

    @OneToOne( targetEntity = ClubEntity.class, mappedBy = "president" )
    private ClubEntity presidentOf;

    @OneToOne( targetEntity = ClubEntity.class, mappedBy = "advisor" )
    private ClubEntity advisorOf;

    @OneToMany( targetEntity = EventPointEntity.class, mappedBy = "user" )
    private List<EventPointEntity> eventPoints;

    @OneToMany( targetEntity = ClubMemberEntity.class, mappedBy = "user" )
    private List<ClubMemberEntity> clubMemberShips;

    @OneToMany( targetEntity = ClubBoardMemberEntity.class, mappedBy = "user" )
    private List<ClubBoardMemberEntity> clubBoardMemberships;

    @ManyToOne( targetEntity = UniversityEntity.class )
    @JoinColumn( name = "university" )
    private UniversityEntity university;
}
