package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.Address;
import model.MemberInfo;

public class MemberInfoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {

		return MemberInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberInfo memberInfo = (MemberInfo) target;
		
		if(memberInfo.getId() == null || memberInfo.getId().isBlank()) {
			errors.rejectValue("id", "required");
			
		}
		
		if(memberInfo.getName() == null || memberInfo.getName().isBlank()) {
			errors.rejectValue("name", "required");
			
		}
		
		Address address = memberInfo.getAddress();
		
		if(address == null) {
			errors.rejectValue("address", "required");
		}
		
		if(address != null) {
			errors.pushNestedPath("address");
			try {
				if(address.getZipcode() == null || address.getZipcode().isBlank()) {
					errors.rejectValue("zipcode", "required");
					
				}
				
				if(address.getAddress1() == null || address.getAddress1().isBlank()) {
					errors.rejectValue("address1", "required");
				}
				
				if(address.getAddress2() == null || address.getAddress2().isBlank()) {
					errors.rejectValue("address2", "required");
				}
				
			}finally {
				errors.popNestedPath();
			}
		}
		
	}

}
