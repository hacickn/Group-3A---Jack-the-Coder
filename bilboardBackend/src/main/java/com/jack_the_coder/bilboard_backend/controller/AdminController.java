package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.io.entity.UniversityEntity;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateClubRequest;
import com.jack_the_coder.bilboard_backend.model.requestModel.CreateUniversityRequest;
import com.jack_the_coder.bilboard_backend.model.responseModel.CreateClubResponse;
import com.jack_the_coder.bilboard_backend.model.responseModel.CreateUniversityResponse;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.service.AdminService;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubDto;
import com.jack_the_coder.bilboard_backend.shared.dto.UniversityDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hacı Çakın
 * @apiNote This is admin controller that consists of create club or university, assign president or advisor. Client
 * interacts with that router.
 * It's path is /bilboard-app/v1/admin
 * @implNote NOT Completed
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

    @PostMapping( path = "/createClub" )
    public CreateClubResponse createClub ( @RequestBody CreateClubRequest createClubRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubDto clubDto = modelMapper.map( createClubRequest , ClubDto.class );
        UniversityDto universityDto = adminService.getUniversity( createClubRequest.getUniversity() );
        UniversityEntity universityEntity = modelMapper.map( universityDto , UniversityEntity.class );
        clubDto.setUniversity( universityEntity );
        ClubDto createdDto = clubService.createClub( clubDto );

        return modelMapper.map( createdDto , CreateClubResponse.class );
    }

    @PostMapping( path = "/createUniversity" )
    public CreateUniversityResponse createUniversity ( @RequestBody CreateUniversityRequest createUniversityRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        UniversityDto universityDto = modelMapper.map( createUniversityRequest , UniversityDto.class );
        UniversityDto createdDto = adminService.createUniversity( universityDto );
        return modelMapper.map( createdDto , CreateUniversityResponse.class );
    }
}
