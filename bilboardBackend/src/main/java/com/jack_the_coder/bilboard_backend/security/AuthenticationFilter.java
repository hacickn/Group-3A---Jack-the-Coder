package com.jack_the_coder.bilboard_backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jack_the_coder.bilboard_backend.model.requestModel.SignInRequest;
import com.jack_the_coder.bilboard_backend.service.UserService;
import com.jack_the_coder.bilboard_backend.shared.dto.UserDto;
import com.jack_the_coder.bilboard_backend.util.SpringApplicationContext;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Hacı Çakın
 * @date 11.12.2021
 */
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    private String contentType;

    public AuthenticationFilter ( AuthenticationManager authenticationManager ) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication ( HttpServletRequest req ,
                                                  HttpServletResponse res ) throws AuthenticationException {
        try {
            contentType = req.getHeader( "Accept" );

            SignInRequest creds = new ObjectMapper()
                    .readValue( req.getInputStream() , SignInRequest.class );

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail() ,
                            creds.getPassword() ,
                            new ArrayList<>() )
            );

        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }

    @Override
    protected void successfulAuthentication ( HttpServletRequest req ,
                                              HttpServletResponse res ,
                                              FilterChain chain ,
                                              Authentication auth ) throws IOException {

        String email = ( ( User ) auth.getPrincipal() ).getUsername();
        String token = Jwts.builder()
                .setSubject( email )
                .setExpiration( new Date( System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME ) )
                .signWith( SignatureAlgorithm.HS512 , SecurityConstants.getTokenSecret() )
                .compact();


        UserService userService = ( UserService ) SpringApplicationContext.getBean( "userServiceImp" );
        UserDto userDto = userService.getUserByEmail( email );
        PrintWriter out = res.getWriter();
        res.setContentType( "application/json" );
        res.setCharacterEncoding( "UTF-8" );
        out.print( "{\"token\":\"" + token + "\", \"email\":\"" + userDto.getEmail() + "\"}" );
    }
}
