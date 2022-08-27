package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@ComponentScan(basePackages = "com.spring")
@ComponentScan(basePackages = {"com.spring.proxy","com.spring.service","com.spring.repository"})
public class ProjectConfig {
}
