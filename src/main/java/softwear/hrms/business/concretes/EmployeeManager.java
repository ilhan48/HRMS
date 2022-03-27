package softwear.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softwear.hrms.business.abstracts.EmployeeService;
import softwear.hrms.core.utilities.business.BusinessRules;
import softwear.hrms.core.utilities.results.DataResult;
import softwear.hrms.core.utilities.results.ErrorResult;
import softwear.hrms.core.utilities.results.Result;
import softwear.hrms.core.utilities.results.SuccessDataResult;
import softwear.hrms.core.utilities.results.SuccessResult;
import softwear.hrms.dataAccess.abstracts.EmployeeDao;
import softwear.hrms.entities.concretes.Employee;
import softwear.hrms.entities.dtos.EmployeeForRegisterDto;

@Service
public class EmployeeManager implements EmployeeService {

	private final EmployeeDao employeeDao;
	private final ModelMapper modelMapper;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, ModelMapper modelMapper) {
		super();
		this.employeeDao = employeeDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}

	@Override
	public Result add(EmployeeForRegisterDto employeeForRegisterDto) {
		var rulesResult = BusinessRules.Run(
				CheckForPassword(employeeForRegisterDto),
				CheckIfEmailAvailable(employeeForRegisterDto),
				CheckIfNationalIdentityExist(employeeForRegisterDto)
				);
		if (rulesResult != null ) {
			return rulesResult;
		}
		Employee employee = modelMapper.map(employeeForRegisterDto, Employee.class);
		modelMapper.map(this.employeeDao.save(employee), EmployeeForRegisterDto.class);
		return new SuccessResult("Success");

	}

	@Override
	public Result delete(Employee employee) {
		this.employeeDao.delete(employee);
		return new SuccessResult("");
	}

	@Override
	public Result update(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("");
	}
	
	//Business Rules

	private Result CheckForPassword(EmployeeForRegisterDto employeeForRegisterDto) {

		var result = employeeForRegisterDto.getPassword().contentEquals(employeeForRegisterDto.getAgainPassword());

		if (result) {
			
			return new SuccessResult();
		}
		
		return new ErrorResult("Password not same!");
	}
	private Result CheckIfNationalIdentityExist(EmployeeForRegisterDto employeeForRegisterDto)
    {
        var employees = employeeDao.findAll();
        for (Employee employee : employees) {
			if (employee.getNationalIdentity().equals(employeeForRegisterDto.getNationalIdentity())) {
				return new ErrorResult("You are already sign up!");
			}
        }
		
        return new SuccessResult();
    }
    
	private Result CheckIfEmailAvailable(EmployeeForRegisterDto employeeForRegisterDto)
    {
        var result = employeeDao.findAll();
        for (Employee employee : result) {
        	if (employee.getUser().getEmail() == employeeForRegisterDto.getEmail())
            {
                return new ErrorResult("Email already sign up!");
            }
		}
        return new SuccessResult();
    }
	
}	
