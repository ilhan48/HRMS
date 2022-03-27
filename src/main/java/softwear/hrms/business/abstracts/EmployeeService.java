package softwear.hrms.business.abstracts;

import java.util.List;

import softwear.hrms.core.utilities.results.DataResult;
import softwear.hrms.core.utilities.results.Result;
import softwear.hrms.entities.concretes.Employee;
import softwear.hrms.entities.dtos.EmployeeForRegisterDto;


public interface EmployeeService {
	
	DataResult<List<Employee>> getAll();
	Result add(EmployeeForRegisterDto employeeForRegisterDto);
	Result delete(Employee employee);
	Result update(Employee employee);

}
