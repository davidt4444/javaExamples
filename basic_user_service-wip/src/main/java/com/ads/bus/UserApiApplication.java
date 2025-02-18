package com.ads.bus;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApiApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(UserApiApplication.class);
        app.setDefaultProperties(Collections.singletonMap("spring.config.location", 
                                                        "file:../../aws-resources/localhost-mac-java2.properties"));
        app.run(args);
    }
}