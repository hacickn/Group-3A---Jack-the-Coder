package com.jack_the_coder.bilboard_backend;

import com.jack_the_coder.bilboard_backend.security.AppProperties;
import com.jack_the_coder.bilboard_backend.util.SpringApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Hacı Çakın
 * @apiNote Main class that runs app
 * @implNote DONE
 * @since 09.11.2021
 */
@SpringBootApplication
public class BilboardBackendApplication {

    public static void main ( String[] args ) {
        SpringApplication.run( BilboardBackendApplication.class , args );
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringApplicationContext springApplicationContext () {
        return new SpringApplicationContext();
    }

    @Bean( name = "AppProperties" )
    public AppProperties getAppProperties () {
        return new AppProperties();
    }

}
