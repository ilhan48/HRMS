package softwear.hrms.business.abstracts;

import java.util.List;

import softwear.hrms.core.utilities.results.DataResult;
import softwear.hrms.core.utilities.results.Result;
import softwear.hrms.entities.concretes.Job;
import softwear.hrms.entities.dtos.JobForAddDto;

public interface JobService {
	
	DataResult<List<Job>> getAll();
	Result add(JobForAddDto jobForAddDto);
	Result delete(Job job);
	Result update(Job job);
	
}
