package com.spring.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// whenever you start the application spring do firstly find class which is include configuration annotation
// then spring is starting the bean for you and put in the container
@Configuration
public class ConfigApp {

    @Bean
    FullTimeMentor fullTimeMentor(){
        return new FullTimeMentor();
    }
//    @Bean(name = "p1")
    @Primary
    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }
//    @Bean(name = "p2")
    @Bean
    PartTimeMentor partTimeMentor2() {
        return new PartTimeMentor();
    }



}
