package stereotype_annotations;

import bean_practice.FullTimeEmployee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.Config;
import stereotype_annotations.model.DataStructure;

public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(Config.class);
        DataStructure dt = container.getBean(DataStructure.class);
        dt.getTotalHours();

        FullTimeEmployee ft = container.getBean(FullTimeEmployee.class);
        ft.createAccount();
    }
}
