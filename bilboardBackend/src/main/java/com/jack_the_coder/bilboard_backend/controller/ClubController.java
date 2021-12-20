package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.model.OperationName;
import com.jack_the_coder.bilboard_backend.model.OperationStatus;
import com.jack_the_coder.bilboard_backend.model.StatusResponse;
import com.jack_the_coder.bilboard_backend.model.requestModel.UpdateClubRequest;
import com.jack_the_coder.bilboard_backend.service.ClubService;
import com.jack_the_coder.bilboard_backend.shared.dto.ClubDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hacı Çakın
 * @apiNote This is club controller that consists of club operations. Client interacts with that router.
 * It's path is /bilboard-app/v1/club
 * @implNote NOT Completed
 * @since 11.12.2021
 */
@CrossOrigin
@RestController
@RequestMapping( "/club" )
public class ClubController {

    @Autowired
    ClubService clubService;

    @PostMapping( path = "/update" )
    public StatusResponse updateClub ( @RequestBody UpdateClubRequest updateClubRequest ) {
        ModelMapper modelMapper = new ModelMapper();
        ClubDto clubDto = modelMapper.map( updateClubRequest , ClubDto.class );
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.UPDATE.name() );

        if ( clubService.updateClub( clubDto ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }

    @PostMapping( path = "/enrollment/request" )
    public StatusResponse enrollClub ( @RequestParam( value = "userId" ) long userId ,
                                       @RequestParam( value = "clubId" ) long clubId ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.ENROLL_REQUEST.name() );
        if ( clubService.enrollClub( userId , clubId ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }

    @PostMapping( path = "/enrollment/respond" )
    public StatusResponse respondEnrollRequest ( @RequestParam( value = "enrollmentId" ) long enrollmentId ,
                                                 @RequestParam( value = "status" ) String status ) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOperationName( OperationName.ENROLL_RESPOND.name() );

        if ( clubService.respondEnrollRequest( enrollmentId , status ) ) {
            statusResponse.setOperationResult( OperationStatus.SUCCESS.name() );
        } else {
            statusResponse.setOperationResult( OperationStatus.ERROR.name() );
        }

        return statusResponse;
    }

}
