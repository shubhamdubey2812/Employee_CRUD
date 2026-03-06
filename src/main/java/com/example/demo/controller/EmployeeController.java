package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		boolean saveEmp = employeeService.saveEmp(employeeDto);
		if(!saveEmp) {
			return ResponseEntity.ofNullable("Name Should not be Empty");
		}else {
		return ResponseEntity.ok("Employee saved successfully");
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		employeeService.deleteEmp(id);
		return ResponseEntity.ok("Employee deleted successfully");
	}
	@GetMapping("/{id}")
	public EmployeeDto getEMployeeById(@PathVariable int id){
		return employeeService.getEmployeeById(id);
	}
	@GetMapping("/all")
	public List<EmployeeDto> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	@GetMapping("/page/{pageNumber}/{pageSize}")
	public Page<EmployeeDto> getPagebleData(@PathVariable int pageNumber,@PathVariable int pageSize){
		return employeeService.getPagebleData(pageNumber, pageSize);		
	}
	@GetMapping("filter/{name}")
	public List<EmployeeDto> getEmployeeByName(@PathVariable String name){
		return employeeService.getFilterdDataNameWise(name);
	}
}
