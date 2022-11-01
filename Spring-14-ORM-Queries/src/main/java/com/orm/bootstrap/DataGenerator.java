package com.orm.bootstrap;

import com.orm.repository.CourseRepository;
import com.orm.repository.DepartmentRepository;
import com.orm.repository.EmployeeRepository;
import com.orm.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;


    public DataGenerator(RegionRepository regionRepository,DepartmentRepository departmentRepository,EmployeeRepository employeeRepository,CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository= employeeRepository;
        this.courseRepository= courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("===============Region start===============");
        // how will i access method that just i built
        System.out.println("findByCountry : " + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry : " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContains : " + regionRepository.findByCountryContains("United"));
        System.out.println("findByCountryContainsOrderByRegion : "+ regionRepository.findByCountryContainsOrderByRegion("Asia"));
        System.out.println("findTop2ByCountry : "+ regionRepository.findTop2ByCountry("Canada"));
        System.out.println("===============Region end=================");

        System.out.println("===============Department start===========");
        System.out.println("findByDepartment : " +departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDivision : " +departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("findDistinctTop3ByDivisionContains : " +departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("===============Department end=============");

        System.out.println("===============Employee start===========");
        System.out.println("findByEmail : "+employeeRepository.findByEmail("dtrail8@tamu.edu"));
        System.out.println("getEmployeeDetail: "+ employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary: "+ employeeRepository.getEmployeeSalary());
        System.out.println("===============Employee end=============");

        System.out.println("===============Course start===========");
        courseRepository.findByCategory("Spring").forEach(System.out::println);
        System.out.println("---------------------");
        courseRepository.findByCategoryOrderByNameDesc("Spring").forEach(System.out::println);
        System.out.println("---------------------");
        System.out.println(courseRepository.existsByName("JAVASCRIPT"));
        System.out.println(courseRepository.countByCategory("Spring"));
        System.out.println("---------------------");
        System.out.println(courseRepository.findByNameStartsWith("Scalable"));

        System.out.println("---------------------");
        courseRepository.streamByCategory("Spring").forEach(System.out::println);
        System.out.println("===============Course end=============");
    }
}
