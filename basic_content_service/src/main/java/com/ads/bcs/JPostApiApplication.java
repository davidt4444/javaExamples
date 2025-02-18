package com.ads.bcs;

import java.util.Collections;
import java.io.*;
import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JPostApiApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(JPostApiApplication.class);
        app.setDefaultProperties(Collections.singletonMap("spring.config.location", 
                                                        "file:../../aws-resources/localhost-mac-java.properties"));
        app.run(args);
    }
}