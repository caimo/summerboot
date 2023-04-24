package com.summerboot.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
@ComponentScan("com.summerboot.restservice")
public class RestServiceApplication {

    public static void main(String[] args) {
        System.out.println(StandardCharsets.UTF_8.toString());

        SpringApplication.run(RestServiceApplication.class, args);

    }

}
