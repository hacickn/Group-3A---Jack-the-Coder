package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.io.entity.UniversityEntity;
import com.jack_the_coder.bilboard_backend.model.OperationName;
import com.jack_the_coder.bilboard_backend.model.OperationStatus;
import com.jack_the_coder.bilboard_backend.model.StatusResponse;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateClubRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateUniversityRequest;
import com.jack_the_coder.bilboard_backend.model.responseModel.AdminClubResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.CreateClubResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.CreateUniversityResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.basicResponseModel.BasicClubResponse;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.service.AdminService;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubDto;
import com.jack_the_coder.bilboard_backend.shared.dto.UniversityDto;
import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hacı Çakın
 * @apiNote This is admin controller that consists of create club or university, assign president or advisor. Client
 * interacts with that router.
 * It's path is /bilboard-app/v1/admin
 * @implNote DONE
 * @since 13.12.2021
 */
@CrossOrigin
@RestController
@RequestMapping( "/admin" )
public class AdminController {

    @Autowired
    ClubService clubService;

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    /**
     * Method for creating a club
     * @param createClubRequest is a CreateClubRequest
     * @return CreateClubResponse
     * @apiNote This method creates a club.
     */
    @PostMapping( path = "/createClub" )
    public BasicClubResponse createClub ( @RequestBody CreateClubRequest createClubRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubDto clubDto = modelMapper.map( createClubRequest , ClubDto.class );
        UniversityDto universityDto = adminService.getUniversity( createClubRequest.getUniversity() );
        UniversityEntity universityEntity = modelMapper.map( universityDto , UniversityEntity.class );
        clubDto.setUniversity( universityEntity );
        ClubDto createdDto = clubService.createClub( clubDto );

        return modelMapper.map( createdDto , BasicClubResponse.class );
    }

    /**
     * Method for creating a university
     * @param createUniversityRequest is a CreateUniversityRequest
     * @return CreateUniversityResponse
     * @apiNote This method creates a university.
     */
    @PostMapping( path = "/createUniversity" )
    public CreateUniversityResponse createUniversity ( @RequestBody CreateUniversityRequest createUniversityRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        UniversityDto universityDto = modelMapper.map( createUniversityRequest , UniversityDto.class );
        UniversityDto createdDto = adminService.createUniversity( universityDto );
        return modelMapper.map( createdDto , CreateUniversityResponse.class );
    }

    /**
     * Method for assigning a president to a club
     * @param clubId is a long
     * @param userId is a long
     * @return StatusResponse
     * @apiNote This method assigns president to a club.
     */
    @PostMapping( path = "/president" )
    public StatusResponse assignPresident ( @RequestParam( value = "clubId" ) long clubId ,
                                            @RequestParam( value = "userId" ) long userId ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );
        ClubDto clubDto = clubService.getClubById( clubId );
        UserDto userDto = userService.getUserById( userId );


        if ( clubService.assignPresident( userDto , clubDto ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }

    /**
     * Method for assigning an advisor to a club
     * @param clubId is a long
     * @param userId is a long
     * @return StatusResponse
     * @apiNote This method assigns advisor to a club.
     */
    @PostMapping( path = "/advisor" )
    public StatusResponse assignAdvisor ( @RequestParam( value = "clubId" ) long clubId ,
                                          @RequestParam( value = "userId" ) long userId ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );
        ClubDto clubDto = clubService.getClubById( clubId );
        UserDto userDto = userService.getUserById( userId );

        if ( clubService.assignAdvisor( userDto , clubDto ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }

    /**
     * Method for getting the clubs
     * @return List<AdminClubResponse>
     * @apiNote This method is used to get clubs.
     */
    @GetMapping( path = "/clubs" )
    public List<AdminClubResponse> getClubs () {
        ModelMapper modelMapper = new ModelMapper();
        List<AdminClubResponse> clubResponseList = new ArrayList<>();
        clubService.searchClub( "" ).forEach( clubDto -> {
            clubResponseList.add( modelMapper.map( clubDto , AdminClubResponse.class ) );
        } );

        return clubResponseList;
    }

}
