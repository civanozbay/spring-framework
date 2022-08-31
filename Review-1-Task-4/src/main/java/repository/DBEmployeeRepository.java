package repository;

import model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{
    // assume info is coming from DB
    @Override
    public int getHouryRate() {
        Employee emp1 = new Employee("Mime","IT",55);

        return emp1.getHourlyRate();
    }
}
