package com.orm.bootstrap;

import com.orm.entity.Department;
import com.orm.entity.Employee;
import com.orm.entity.Region;
import com.orm.enums.Gender;
import com.orm.repository.DepartmentRepository;
import com.orm.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    EmployeeRepository employeeRepository;
//    DepartmentRepository departmentRepository;

    public DataGenerator(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
//        this.departmentRepository= departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentsList = new ArrayList<>();
        Employee e1 = new Employee("Berrie","Manaue","bmaneus@gmail.com", LocalDate.of(2006,04,23), Gender.MALE,5000);
        Employee e2 = new Employee("Clerk","Thompson","clarmelon@gmail.com", LocalDate.of(2007,04,23), Gender.MALE,5000);
        Employee e3 = new Employee("Komaci","Ja","kamakaze@gmail.com", LocalDate.of(2006,01,25), Gender.FEMALE,15000);
        Employee e4 = new Employee("Tarime","Kemal","teka@gmail.com", LocalDate.of(2009,02,3), Gender.MALE,4000);
        Employee e5 = new Employee("Lokem","Lila","lole@gmail.com", LocalDate.of(2005,03,8), Gender.MALE,3000);

        Department d1 = new Department("Sports","Outdoors");
        Department d2 = new Department("Tools","Hardware");
        Department d3 = new Department("Clothing","Home");
        Department d4 = new Department("Phones","Electronics");
        Department d5 = new Department("Computers","Electronics");


        Region r1 = new Region("Southwest","United States");
        Region r2 = new Region("Central","United States");
        Region r3 = new Region("Northwest","United States");
        Region r4 = new Region("Quebec'","Canada");
        Region r5 = new Region("Central","Asia");


        e1.setDepartment(d1);
        e2.setDepartment(d2);
        e3.setDepartment(d3);
        e4.setDepartment(d4);
        e5.setDepartment(d5);


        e1.setRegion(r1);
        e2.setRegion(r2);
        e3.setRegion(r3);
        e4.setRegion(r4);
        e5.setRegion(r5);

        employeeList.addAll(Arrays.asList(e1,e2,e3,e4,e5));
        departmentsList.addAll(Arrays.asList(d1,d2,d3,d4,d5));

        employeeRepository.saveAll(employeeList);
//        departmentRepository.saveAll(departmentsList);
    }
}
