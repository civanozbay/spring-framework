package com.orm.repository;

import com.orm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //display all employees with email address
    List<Employee> findByEmail(String email);
    //display all employees with first name ' ' and last name ' ', also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName ,String email);
    // display all employees that first name is not ' '
    List<Employee> findByFirstNameIsNot(String firstName);
    // display all employees where last name start with ' '
    List<Employee> findByLastNameStartsWith(String pattern);
    // display all employees with salaries higher than ' '
    List<Employee> findBySalaryGreaterThan(Integer salary);
    // display all employees with salaries less than ' '
    List<Employee> findBySalaryLessThanEqual(Integer salary);
    // display all employees that has been hired between ' ' and ' '
    List<Employee> findByHireDateBetween(LocalDate firstDate,LocalDate secondDate);
    // display all employees where salaries greater and equal to ' ' in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);
    // display top unique 3 employees that is making less than ' '
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);
    // display all employees that do not have email address
    List<Employee> findByEmailIsNull();

    @Query("SELECT e FROM Employee e where e.email= 'dtrail8@tamu.edu'")
    Employee getEmployeeDetail();
    @Query("SELECT e.salary FROM Employee e where e.email='dtrail8@tamu.edu'")
    Integer getEmployeeSalary();

    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);
    @Query("SELECT e FROM  Employee e WHERE e.email=?1 AND e.salary=?2")
    Employee getEmployeeDetail(String email,int salary);

    // not equal
    @Query("SELECT e from Employee e where e.salary <> ?1 ")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    //like/contains/startswith/endswith
    @Query("SELECT  e from  Employee e where e.firstName like ?1" )
    List<Employee> getEmployeeFirstNameLike(String pattern);

    //less than
    @Query("select e from Employee e where e.salary< ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    //greater than
    @Query("select e from Employee e where e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    //Before
    @Query("SELECT e FROM Employee e where e.hireDate >?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    // between
    @Query("SELECT e FROM Employee e WHERE e.salary Between ?1 and ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    //null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeEmailIsNull();

    //Sorting in ascending order
    @Query("select e from Employee e order by e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    //Sorting in descending order
    @Query("select e from Employee e order by e.salary desc ")
    List<Employee> getEmployeeSalaryOrderDesc();

    @Query(value = "SELECT * FROM employees WHERE salary ?1",nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);

    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e set e.email = 'admin@email.com' where  e.id= :id")
    void updateEmployeeJPQL(@Param("id")int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees set email = 'admin@email.com' where id= :id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id")int id);






}
