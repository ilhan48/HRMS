package softwear.hrms.business.abstracts;


import java.util.List;

import softwear.hrms.core.entities.User;
import softwear.hrms.core.utilities.results.DataResult;
import softwear.hrms.core.utilities.results.Result;

public interface UserService {
	
	DataResult<List<User>> getall(User user);
	Result add(User user);
	Result update(User user);
	Result delete(User user);

}
