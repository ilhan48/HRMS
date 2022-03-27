package softwear.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import softwear.hrms.entities.concretes.Employeer;

public interface EmployeerDao extends JpaRepository<Employeer, Integer>{

}
