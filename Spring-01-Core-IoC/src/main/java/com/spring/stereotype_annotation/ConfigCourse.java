package com.spring.stereotype_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
@ComponentScan(basePackages = "com.spring") // it will look for another package if you define like this
public class ConfigCourse {

}
