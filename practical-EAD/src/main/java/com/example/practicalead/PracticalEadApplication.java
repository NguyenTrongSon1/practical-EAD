package com.example.practicalead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PracticalEadApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticalEadApplication.class, args);
    }

}
