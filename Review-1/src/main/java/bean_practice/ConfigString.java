package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigString {
    @Bean(name = "message1")
    String str(){
        return "welcome to spring";
    }
    @Bean(name = "message2")
    String str2(){
        return "Spring core practice";
    }
}
