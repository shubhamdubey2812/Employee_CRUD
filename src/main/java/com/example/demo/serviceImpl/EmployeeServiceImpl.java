package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.enity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private ModelMapper mapper;
	@Override
	public boolean saveEmp(EmployeeDto epmDto) {
		if(epmDto.getName().isEmpty() ||epmDto.getName().isEmpty()) {
			return false;
		}
		Employee emp=mapper.map(epmDto, Employee.class);
		empRepo.save(emp);
		return true;
	}

	@Override
	public void deleteEmp(int id) {
		empRepo.deleteById(id);
	}

	@Override
	public EmployeeDto updateEmp(EmployeeDto employeeDto) {
		Employee emp=mapper.map(employeeDto, Employee.class);
		Employee update=empRepo.save(emp);
		return mapper.map(update, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeById(int id) {

	    Employee employee = empRepo.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Employee Not Found with given id " + id,
	                            HttpStatus.NOT_FOUND));
	    return mapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> all = empRepo.findAll();
		    return all.stream()
		              .map(e -> mapper.map(e, EmployeeDto.class))
		              .collect(Collectors.toList());
	}
	@Override
	public Page<EmployeeDto> getPagebleData(int pageNumber,int pageSize){
		Pageable pageable=PageRequest.of(pageNumber, pageSize);
		Page<Employee> employee=empRepo.findAll(pageable);
		return employee.map(e->mapper.map(e, EmployeeDto.class));
	}

	@Override
	public List<EmployeeDto> getFilterdDataNameWise(String name) {
		List<Employee> empList=empRepo.findEmployeeByName(name);
		List<EmployeeDto> dtoList=empList.stream().map(e->mapper.map(e, EmployeeDto.class))
				.collect(Collectors.toList());
		return dtoList;
	}

}
