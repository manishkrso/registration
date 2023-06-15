package com.soni.app.registration.entity;

import com.soni.app.registration.helpers.ValidatorClasses;

public class UserHelper {
	
	ValidatorClasses validate = new ValidatorClasses();

	public Boolean isValidUser(User user) {

		Boolean email, firstname,lastname, phone;
				
				email= isValidEmail(user.getEmailId());
				System.out.println("Is Email Valid: "+email);
				
				firstname= isValidFirstName(user.getFirstName());
				System.out.println("Is FirstName Valid: "+firstname);
				
				lastname=isValidLastname(user.getLastName());
				System.out.println("Is Lastname Valid: "+lastname);
				
				phone = isValidPhone(user.getPhone());
				System.out.println("Is Phone No. Valid: "+phone);
				
				return email&&firstname&&lastname&&phone;
	}

	public Boolean isValidEmail(String emailId) {

		return validate.isValidEmail(emailId);
	}
	
	public Boolean isValidPhone(long phone) {

		
		return validate.isValidPhone(phone);
	}
	
	public Boolean isValidFirstName(String firstName) {

		return validate.isValidName(firstName);
	}
	public Boolean isValidLastname(String lastName) {

		return validate.isValidName(lastName);
	}
}
