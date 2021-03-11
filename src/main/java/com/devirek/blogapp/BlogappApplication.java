package com.devirek.blogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogappApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogappApplication.class, args);

        System.out.println(" ".length());
    }

}
