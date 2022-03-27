package softwear.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import softwear.hrms.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
