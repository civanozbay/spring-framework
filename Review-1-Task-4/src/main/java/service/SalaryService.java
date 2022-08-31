package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import repository.EmployeeRepository;
import repository.HoursRepository;
@Component
public class SalaryService {

    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;

    public SalaryService(EmployeeRepository employeeRepository,@Qualifier("RH") HoursRepository hoursRepository){
        this.employeeRepository=employeeRepository;
        this.hoursRepository=hoursRepository;
    }
    public void calculateRegularSalary(){
        System.out.println(employeeRepository.getHouryRate()*hoursRepository.getHours());
    }
}
