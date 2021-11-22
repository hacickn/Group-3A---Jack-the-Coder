package com.jack_the_coder.bilboard_backend.util;

import com.jack_the_coder.bilboard_backend.security.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

/**
 * @author Hacı Çakın
 * @apiNote Web config file for construction cors policy
 * @implNote DONE
 * @since 22.11.2021
 */
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generatePublicId ( int length ) {
        return generateRandomString( length );
    }

    public String generateRandomString ( int length ) {
        StringBuilder returnValue = new StringBuilder( length );

        for ( int i = 0 ; i < length ; i++ ) {
            returnValue.append( ALPHABET.charAt( RANDOM.nextInt( ALPHABET.length() ) ) );
        }

        return new String( returnValue );
    }

    public static boolean hasTokenExpired ( String token ) {
        boolean returnValue;

        try {
            Claims claims = Jwts.parser().setSigningKey( SecurityConstants.getTokenSecret() ).parseClaimsJws( token )
                    .getBody();

            Date tokenExpirationDate = claims.getExpiration();
            Date todayDate = new Date();

            returnValue = tokenExpirationDate.before( todayDate );
        } catch ( ExpiredJwtException ex ) {
            returnValue = true;
        }

        return returnValue;
    }

    public String generateEmailVerificationToken ( String userId ) {
        String token = Jwts.builder()
                .setSubject( userId )
                .setExpiration( new Date( System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME ) )
                .signWith( SignatureAlgorithm.HS512 , SecurityConstants.getTokenSecret() )
                .compact();
        return token;
    }

    public String generatePasswordResetToken ( String userId ) {
        String token = Jwts.builder()
                .setSubject( userId )
                .setExpiration( new Date( System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME ) )
                .signWith( SignatureAlgorithm.HS512 , SecurityConstants.getTokenSecret() )
                .compact();
        return token;
    }
}
