package com.orm.repository;

import com.orm.entity.Department;
import com.orm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {

    // display all departments in the furniture department
    List<Department> findByDepartment(String department);
    //display all departments in the Health Division
    List<Department> findByDivisionIs(String department);
    List<Department> findByDivisionEquals(String department);
    //display top 3 departments with division name includes 'Hea' without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String pattern);

    @Query("SELECT d FROM Department d WHERE d.division in ?1")
    List<Department> getDepartmentDivision(List<String> division);

    List<Department> retrieveDepartmentByDivision(String division);
    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);

}
