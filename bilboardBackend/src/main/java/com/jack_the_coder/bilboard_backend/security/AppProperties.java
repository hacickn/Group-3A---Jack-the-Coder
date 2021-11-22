package com.jack_the_coder.bilboard_backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Hacı Çakın
 * @apiNote App properties to reach env variables
 * @implNote DONE
 * @since 22.11.2021
 */
@Component
public class AppProperties {

    @Autowired
    private Environment env;

    public String getTokenSecret () {
        return env.getProperty( "tokenSecret" );
    }
}
