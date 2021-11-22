package com.jack_the_coder.bilboard_backend.security;

import com.jack_the_coder.bilboard_backend.util.SpringApplicationContext;

/**
 * @author Hacı Çakın
 * @apiNote Security constants for the applications( some endpoints added here to make them public )
 * @implNote DONE
 * @since 22.11.2021
 */
public class SecurityConstants {

    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final long PASSWORD_RESET_EXPIRATION_TIME = 3600000; // 1 hour
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public static String getTokenSecret () {
        AppProperties appProperties = ( AppProperties ) SpringApplicationContext.getBean( "AppProperties" );
        return appProperties.getTokenSecret();
    }
}
