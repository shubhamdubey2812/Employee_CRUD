package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.enity.Employee;
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	@Query("SELECT emp FROM Employee emp WHERE emp.name = :name")
	List<Employee> findEmployeeByName(@Param("name") String name);
}
