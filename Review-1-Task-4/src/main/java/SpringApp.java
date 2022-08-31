import config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.SalaryService;

public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(Config.class);
        SalaryService bean = container.getBean(SalaryService.class);
        bean.calculateRegularSalary();
    }
}
