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

import softwear.hrms.business.abstracts.EmployeerService;
import softwear.hrms.core.utilities.results.DataResult;
import softwear.hrms.core.utilities.results.Result;
import softwear.hrms.entities.concretes.Employeer;
import softwear.hrms.entities.dtos.EmployeerForRegisterDto;

@RestController
@RequestMapping("/api/employeer")
public class EmployeerController {
	
	private EmployeerService employeerService;
	
	@Autowired
	public EmployeerController(EmployeerService employeerService) {
		super();
		this.employeerService = employeerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employeer>> getall(){
		return employeerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody EmployeerForRegisterDto employeer){
		return employeerService.add(employeer);
	}
	
	@PutMapping("/update")
	public Result update(@Valid Employeer employeer){
		 return employeerService.update(employeer);
		
	}
	
	@DeleteMapping("/delete")
	public Result delete(Employeer employeer){
		return employeerService.delete(employeer);
	}

}
