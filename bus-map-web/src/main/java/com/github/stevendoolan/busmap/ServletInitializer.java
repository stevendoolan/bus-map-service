package com.github.stevendoolan.busmap;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * To ensure the application starts when deployed to Tomcat as a WAR.
 *
 * Created by Steven Doolan on 22/05/2016.
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
