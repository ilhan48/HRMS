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

import softwear.hrms.business.abstracts.JobService;
import softwear.hrms.core.utilities.results.DataResult;
import softwear.hrms.core.utilities.results.Result;
import softwear.hrms.entities.concretes.Job;
import softwear.hrms.entities.dtos.JobForAddDto;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	
	private JobService jobService;
	
	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}


	@GetMapping("/getall")
	public DataResult<List<Job>> getAll(){
		return jobService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobForAddDto job) {
		return this.jobService.add(job);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Job job) {
		return this.jobService.update(job);
	}
	
	@DeleteMapping("/delete")
	public Result delete(Job job) {
		return this.jobService.delete(job);
	}
}
