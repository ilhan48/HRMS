package softwear.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softwear.hrms.business.abstracts.EmployeerService;
import softwear.hrms.core.utilities.results.DataResult;
import softwear.hrms.core.utilities.results.Result;
import softwear.hrms.core.utilities.results.SuccessDataResult;
import softwear.hrms.core.utilities.results.SuccessResult;
import softwear.hrms.dataAccess.abstracts.EmployeerDao;
import softwear.hrms.entities.concretes.Employeer;
import softwear.hrms.entities.dtos.EmployeerForRegisterDto;

@Service
public class EmployeerManager implements EmployeerService{
	
	private final EmployeerDao employeerDao;
	private final ModelMapper modelMapper;

	@Autowired
	public EmployeerManager(EmployeerDao employeerDao, ModelMapper modelMapper) {
		super();
		this.employeerDao = employeerDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<Employeer>> getAll() {
		return new SuccessDataResult<List<Employeer>>(this.employeerDao.findAll());
	}

	@Override
	public Result add(EmployeerForRegisterDto employeerForRegisterDto) {
		Employeer employeer = modelMapper.map(employeerForRegisterDto, Employeer.class);
		modelMapper.map(this.employeerDao.save(employeer), EmployeerForRegisterDto.class);
		return new SuccessResult();
	}

	@Override
	public Result delete(Employeer employeer) {
		this.employeerDao.delete(employeer);
		return new SuccessResult();
	}

	@Override
	public Result update(Employeer employeer) {
		this.employeerDao.save(employeer);
		return new SuccessResult();
	}

}
