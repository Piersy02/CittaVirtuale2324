package com.ids.ProgettoIDS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD

@SpringBootApplication
=======
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.ids.ProgettoIDS.Model"})
>>>>>>> origin/master
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
<<<<<<< HEAD
=======

>>>>>>> origin/master
}