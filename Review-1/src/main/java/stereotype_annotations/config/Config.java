package stereotype_annotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"stereotype_annotations.model","bean_practice"})
@Configuration
public class Config {

}
