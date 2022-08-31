package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    FullTimeEmployee fullTimeEmployee(){
        return new FullTimeEmployee();
    }
    @Bean
    PartTimeEmployee partTimeEmployee(){
        return new PartTimeEmployee();
    }
}
