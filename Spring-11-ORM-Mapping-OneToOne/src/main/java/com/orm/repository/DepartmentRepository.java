package com.orm.repository;

import com.orm.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
