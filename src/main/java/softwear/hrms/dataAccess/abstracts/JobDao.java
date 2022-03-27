package softwear.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import softwear.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{
		
}
