package com.soni.app.registration.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorClasses {

	String nameRegex="^[a-zA-Z]*[']?[a-zA-Z]*$";
	
	//String emailRegex="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	String emailRegex="^[a-zA-Z0-9.!#$%&’*+\\=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
	
	String phoneRegex="^\\d{10}$";
	
	public Boolean isValidEmail(String emailId) {

		if(emailId.isBlank()) {
			return false;
		}
			
		
		Pattern patern = Pattern.compile(emailRegex);
		Matcher matcher=patern.matcher(emailId);
		return matcher.find();
		
	}
	
	
	public Boolean isValidPhone(long phone) {

		String phoneStr=Long.toString(phone);
		if(phoneStr.isBlank()) {
			return false;
		}
			
		
		Pattern patern = Pattern.compile(phoneRegex);
		Matcher matcher=patern.matcher(phoneStr);
		return matcher.find();
		
	}
	public Boolean isValidName(String name) {

		if(name.isBlank()) {
			return false;
		}
		Pattern patern = Pattern.compile(nameRegex);
		Matcher matcher=patern.matcher(name);
		return matcher.find();
		
	}
}
