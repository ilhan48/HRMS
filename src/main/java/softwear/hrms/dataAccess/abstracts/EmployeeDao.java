package softwear.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import softwear.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
