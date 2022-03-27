package softwear.hrms.entities.dtos;

import lombok.Data;

@Data
public class EmployeerForRegisterDto {

	private String companyName;
	private String website;
	private String phoneNumber;
	private String email;
	private String password;
	private String againPassword;
	
}
