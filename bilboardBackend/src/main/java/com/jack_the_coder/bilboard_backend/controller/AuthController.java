package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.model.requestModel.SignUpRequestModel;
import com.jack_the_coder.bilboard_backend.model.responseModel.SignUpResponse;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping( "/auth" )
public class AuthController {  // http://localhost:8080/bilboard-app/v1/auth


    @Autowired
    UserService userService;

    @PostMapping( path = "/signUp" )  // http://localhost:8080/bilboard-app/v1/auth/signUp
    public SignUpResponse signUp ( @RequestBody SignUpRequestModel requestModel ) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map( requestModel , UserDto.class );   // modelMapper.map(source, target.class);
        UserDto createdDto = userService.createUser( userDto );
        return  modelMapper.map( createdDto , SignUpResponse.class );
    }

}
