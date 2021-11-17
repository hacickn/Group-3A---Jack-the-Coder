package com.jack_the_coder.bilboard_backend.io.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Aslı Dinç
 * @apiNote This class is base structure of the buildings in database
 * @implNote DONE
 * @since 11.11.2021
 */
@Entity( name = "buildings" )
public class BuildingEntity implements Serializable {

    private static final long serialVersionUID = -3993541896569285225L;

    @GeneratedValue
    @Id
    @Column( name = "id" )
    private long id;

    @Column( name = "name", length = 45, nullable = false )
    private String name;

    @ManyToOne( targetEntity = UniversityEntity.class )
    @JoinColumn( name = "university" )
    private UniversityEntity university;

    @OneToMany( targetEntity = ClassroomEntity.class, mappedBy = "building" )
    private List<ClassroomEntity> classrooms;

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
     * Get university method
     * @return UniversityEntity object
     */
    public UniversityEntity getUniversity () {
        return university;
    }

    /**
     * Set survey method
     * @param university is UniversityEntity instance
     */
    public void setUniversity ( UniversityEntity university ) {
        this.university = university;
    }

    /**
     * Get classrooms method
     * @return ClassroomEntity list
     */
    public List<ClassroomEntity> getClassrooms () {
        return classrooms;
    }

    /**
     * Set classrooms method
     * @param classrooms is ClassroomEntity list
     */
    public void setClassrooms ( List<ClassroomEntity> classrooms ) {
        this.classrooms = classrooms;
    }
}
