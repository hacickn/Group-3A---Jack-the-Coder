package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın, Aslı Dinç
 * @since  09.11.2021
 * @apiNote This class is base structure of the users table in database
 * @implNote After completing relations, getters and setters should be implemented
 */
@Entity( name = "users" )
public class UserEntity implements Serializable {

    public enum UserTypes {
        student,
        academic,
        admin,
        administrativeAssistants,
    }

    private static final long serialVersionUID = -6395963018803738532L;

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

    // todo many-to-one => university,

    // todo one-to-many => eventParticipants, surveyParticipants, clubFeedbacks, eventQuestions,
    //  clubBoardMembers, clubMembers, eventAttendNumbers,

    // todo one-to-one => clubs(president-advisor)

    @OneToMany( targetEntity = EventPointEntity.class, mappedBy = "user" )
    private List<EventPointEntity> eventPoints;

}
