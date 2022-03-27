package softwear.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import softwear.hrms.business.abstracts.EmployeeService;
import softwear.hrms.core.utilities.results.DataResult;
import softwear.hrms.core.utilities.results.Result;
import softwear.hrms.entities.concretes.Employee;
import softwear.hrms.entities.dtos.EmployeeForRegisterDto;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getall(){
		return employeeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody EmployeeForRegisterDto employee){
		return employeeService.add(employee);
	}
	
	@PutMapping("/update")
	public Result update(@Valid Employee employee){
		 return employeeService.update(employee);
		
	}
	
	@DeleteMapping("/delete")
	public Result delete(Employee employee){
		return employeeService.delete(employee);
	}
		
	
	
	

}
