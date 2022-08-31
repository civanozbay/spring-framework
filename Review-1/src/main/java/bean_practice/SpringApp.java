package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(Config.class, ConfigString.class);
        FullTimeEmployee ft = container.getBean(FullTimeEmployee.class);
        PartTimeEmployee pt = container.getBean(PartTimeEmployee.class);
        ft.createAccount();
        pt.createAccount();

        String str = container.getBean("message1",String.class);
        System.out.println(str);

    }
}
