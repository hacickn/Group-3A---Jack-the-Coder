package com.jack_the_coder.bilboard_backend.shared.dto;

import com.jack_the_coder.bilboard_backend.io.entity.ClubEntity;
import com.jack_the_coder.bilboard_backend.io.entity.UserEntity;

import java.io.Serializable;

/**
 * @author Aslı Dinç
 * @apiNote This class is data transfer object of the club board members
 * @implNote NOT Completed
 * @since 20.12.2021
 */
public class ClubBoardMemberDto implements Serializable {

    private static final long serialVersionUID = -4301452349294441115L;

    private long id;
    private UserEntity user;
    private ClubEntity club;

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public UserEntity getUser () {
        return user;
    }

    public void setUser ( UserEntity user ) {
        this.user = user;
    }

    public ClubEntity getClub () {
        return club;
    }

    public void setClub ( ClubEntity club ) {
        this.club = club;
    }
}
