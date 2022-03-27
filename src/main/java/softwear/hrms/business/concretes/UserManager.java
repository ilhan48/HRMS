package softwear.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softwear.hrms.business.abstracts.UserService;
import softwear.hrms.core.dataAccess.UserDao;
import softwear.hrms.core.entities.User;
import softwear.hrms.core.utilities.results.DataResult;
import softwear.hrms.core.utilities.results.Result;
import softwear.hrms.core.utilities.results.SuccessDataResult;
import softwear.hrms.core.utilities.results.SuccessResult;


@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getall(User user) {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}

	@Override
	public Result add(User user) {
		
//		var result = BusinessRules.Run(
//				null
//				);
//		
//		if (result != null) {
//			return new ErrorResult();
//		}
		
		this.userDao.save(user);
		return new SuccessResult();
	}

	@Override
	public Result update(User user) {
		this.userDao.save(user);
		return new SuccessResult();
	}

	@Override
	public Result delete(User user) {
		this.userDao.delete(user);
		return new SuccessResult();
	}
	
	//Business Rules
	
	
	



	

}
