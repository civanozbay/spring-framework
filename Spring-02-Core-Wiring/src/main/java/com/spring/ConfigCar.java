package com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {
    @Bean
    Car car(){
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }
    //Direct wiring
//    @Bean
//    Person person(){
//        Person p = new Person();
//        p.setName("Mike");
//        p.setCar(car());
//        return p;
//    }
    //Auto wiring
    @Bean
    Person person(Car c){
        Person p = new Person();
        p.setName("Mike");
        p.setCar(c);
        return p;
    }
}
