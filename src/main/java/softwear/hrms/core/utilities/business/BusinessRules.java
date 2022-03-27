package softwear.hrms.core.utilities.business;

import softwear.hrms.core.utilities.results.Result;

public class BusinessRules {
	
	public static Result Run(Result... logics) {
		for (var logic : logics) {
			
			if (!logic.isSuccess()) {
				return logic;
			}
			
		}
		
		return null;
	}

}
