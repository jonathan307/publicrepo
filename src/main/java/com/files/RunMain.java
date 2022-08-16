package com.files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource(value = {"file:local.properties"}, ignoreResourceNotFound = true)
public class RunMain {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RunMain.class, args);
        Environment env = context.getEnvironment();
        try {
            System.out.println("Application started successfully");
            System.out.println("Connecting to Database: " + env.getProperty("postgres.datasource.url"));
        } catch (Exception e) {
            System.out.println("The exception is: " + e);
        }
    }

}
