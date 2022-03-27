package softwear.hrms.entities.dtos;

import java.util.Date;

import lombok.Data;


@Data
public class EmployeeForRegisterDto {
	
	private String firstName;
	private String lastName;
	private String nationalIdentity;
	private Date dateOfBirth;
	private String email;
	private String password;
	private String againPassword;
	
}
