package com.mihailsergeevichs.imageboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class ImageboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageboardApplication.class, args);
    }
}
