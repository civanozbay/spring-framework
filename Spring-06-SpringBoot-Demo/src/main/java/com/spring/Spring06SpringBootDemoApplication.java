package com.spring;

import com.spring.model.Comment;
import com.spring.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring06SpringBootDemoApplication {

    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context = SpringApplication.run(Spring06SpringBootDemoApplication.class, args);

        CommentService cs = context.getBean(CommentService.class);
        cs.publishComment(comment);

    }

}
