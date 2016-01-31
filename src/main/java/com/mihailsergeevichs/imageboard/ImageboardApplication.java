package com.mihailsergeevichs.imageboard;

import com.mihailsergeevichs.imageboard.entity.Board;
import com.mihailsergeevichs.imageboard.entity.Post;
import com.mihailsergeevichs.imageboard.service.BoardService;
import com.mihailsergeevichs.imageboard.service.BoardServiceImpl;
import com.mihailsergeevichs.imageboard.service.ThreadService;
import com.mihailsergeevichs.imageboard.service.ThreadServiceImpl;
import org.joda.time.DateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.mihailsergeevichs.imageboard.entity.Thread;

import java.util.LinkedList;
import java.util.List;


@ComponentScan
@SpringBootApplication
public class ImageboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageboardApplication.class, args);
    }

}
