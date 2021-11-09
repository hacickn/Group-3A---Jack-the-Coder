package com.jack_the_coder.bilboard_backend.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This class is base structure of the surveys table in database
 * @implNote After completing relations, getters and setters should be implemented
 * @since 09.11.2021
 */
@Entity( name = "surveys" )
public class SurveyEntity implements Serializable {

    public enum SurveyStatus {
        active,
        not_active,
        done
    }

    private static final long serialVersionUID = -4024738873745817001L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "title", length = 100, nullable = false )
    private String title;

    @Column( name = "photo", length = 100 )
    private String photo;

    @Column( name = "start_date" )
    private Date startDate;

    @Column( name = "end_date" )
    private Date endDate;

    @Enumerated( EnumType.STRING )
    @Column( name = "status" )
    private SurveyStatus status;

    @Column( name = "is_for_active_members" )
    private Boolean isForActiveMembers;

    // todo
    //  one-to-many => survey participants
    //  many-to-one => clubs
    @OneToMany( targetEntity = SurveyChoiceEntity.class, mappedBy = "survey" )
    private List<SurveyChoiceEntity> choices;

}
