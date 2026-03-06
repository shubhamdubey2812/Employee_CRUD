package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dto.EmployeeDto;

public interface EmployeeService {
	public boolean saveEmp(EmployeeDto epmDto);
	public void deleteEmp(int id);
	public EmployeeDto updateEmp(EmployeeDto employeeDto);
	public EmployeeDto getEmployeeById(int id);
	public List<EmployeeDto> getAllEmployee();
	public Page<EmployeeDto> getPagebleData(int pageNumber,int pageSize);
	public List<EmployeeDto> getFilterdDataNameWise(String name);
}
