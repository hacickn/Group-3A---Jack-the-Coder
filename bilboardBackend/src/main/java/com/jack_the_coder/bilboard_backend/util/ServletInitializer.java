package com.jack_the_coder.bilboard_backend.util;

import com.jack_the_coder.bilboard_backend.BilboardBackendApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Hacı Çakın
 * @apiNote For running backend app
 * @implNote DONE
 * @since 22.11.2021
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure ( SpringApplicationBuilder application ) {
        return application.sources( BilboardBackendApplication.class );
    }
}
