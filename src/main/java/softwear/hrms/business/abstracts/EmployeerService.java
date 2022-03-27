package softwear.hrms.business.abstracts;

import java.util.List;

import softwear.hrms.core.utilities.results.DataResult;
import softwear.hrms.core.utilities.results.Result;
import softwear.hrms.entities.concretes.Employeer;
import softwear.hrms.entities.dtos.EmployeerForRegisterDto;



public interface EmployeerService {
	DataResult<List<Employeer>> getAll();
	Result add(EmployeerForRegisterDto employeerForRegisterDto);
	Result delete(Employeer employeer);
	Result update(Employeer employeer);
}
