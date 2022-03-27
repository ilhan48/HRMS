package softwear.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softwear.hrms.business.abstracts.JobService;
import softwear.hrms.core.utilities.results.DataResult;
import softwear.hrms.core.utilities.results.Result;
import softwear.hrms.core.utilities.results.SuccessDataResult;
import softwear.hrms.core.utilities.results.SuccessResult;
import softwear.hrms.dataAccess.abstracts.JobDao;
import softwear.hrms.entities.concretes.Job;
import softwear.hrms.entities.dtos.JobForAddDto;

@Service
public class JobManager implements JobService{
	
	private JobDao jobDao;
	private ModelMapper modelMapper;

	@Autowired
	public JobManager(JobDao jobDao, ModelMapper modelMapper) {
		super();
		this.jobDao = jobDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Listed jobs!");
				
	}

	@Override
	public Result add(JobForAddDto jobForAddDto) {
		
		Job job = modelMapper.map(jobForAddDto, Job.class);
		modelMapper.map(this.jobDao.save(job), JobForAddDto.class);
		return new SuccessResult();
		
	}

	@Override
	public Result delete(Job job) {
		this.jobDao.delete(job);
		return new SuccessResult();
	}

	@Override
	public Result update(Job job) {
		this.jobDao.save(job);
		return new SuccessResult();
	}

}
