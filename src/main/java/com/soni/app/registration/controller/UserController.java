package com.soni.app.registration.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soni.app.registration.entity.ActivationToken;
import com.soni.app.registration.entity.User;
import com.soni.app.registration.entity.UserHelper;
import com.soni.app.registration.repo.ActivationTokenDTO;
import com.soni.app.registration.repo.UserDTO;

@RestController
public class UserController {

	@Autowired
	UserDTO userDto;
	
	ActivationToken token;
	
	@Autowired
	ActivationTokenDTO tokenDTO;

	@GetMapping("/user")
	public ResponseEntity<List<User>> getUser() {

		return new ResponseEntity<List<User>>(userDto.findAll(), HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable UUID userId) {
		Optional<User> user = userDto.findById(userId);
		if (user.isPresent()) {
			User userResult = user.get();
			return new ResponseEntity<>(userResult, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/user")
	public ResponseEntity<String> createUser(@RequestBody User reqUser) {

		UserHelper userHelp = new UserHelper();
		if(!userHelp.isValidUser(reqUser)) {
			
			return new ResponseEntity<String>("Error: Special Character Not Allowed in Name. Make sure email ID and Phone are in proper format ! ",
					HttpStatus.PRECONDITION_FAILED);
		}
		
		if (userDto.findByEmailId(reqUser.getEmailId()).isEmpty()
				&& userDto.findByPhone(reqUser.getPhone()).isEmpty()) {
			User savedUser = userDto.save(reqUser);
			
			//Creating token
			
			token= new ActivationToken();
			token.setUserId(savedUser.getUserID());
			token.setIsValid(true);
			token.setCreatedAt(new Date(System.currentTimeMillis()));
			//token.getCreatedAt()
			token = tokenDTO.save(token);
			System.out.println(token);
			return new ResponseEntity<String>(savedUser.getUserID().toString(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Error: EmailID or Phone Already registerred in System ",
					HttpStatus.PRECONDITION_FAILED);
		}

	}

}
