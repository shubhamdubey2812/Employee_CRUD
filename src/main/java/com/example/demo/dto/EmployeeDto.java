package com.example.demo.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	@NotNull(message = "Name cannot be null")
	@Pattern(regexp = "^[A-Za-z]{3,}$", message = "Name must contain only letters and at least 2 characters")
	private String name;
	@NotNull(message = "Address cannot be null")
	private String address;
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits")
	private String moNo;

}
