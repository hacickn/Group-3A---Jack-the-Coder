package com.jack_the_coder.bilboard_backend.controller;

import com.jack_the_coder.bilboard_backend.model.responseModel.UserResponse;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping( "/user" )
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public UserResponse getUser ( @RequestParam( value = "userId" ) long userId ) {
        ModelMapper modelMapper = new ModelMapper();

        UserDto userDto = userService.getUserById( userId );

        return modelMapper.map( userDto , UserResponse.class );
    }
}
