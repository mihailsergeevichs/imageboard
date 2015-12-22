package com.mihailsergeevichs.imageboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;

@ComponentScan
@SpringBootApplication
public class ImageboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageboardApplication.class, args);
    }

}
