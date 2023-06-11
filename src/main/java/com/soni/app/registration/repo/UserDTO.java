package com.soni.app.registration.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soni.app.registration.entity.User;

public interface UserDTO extends JpaRepository<User, UUID> {

	List<User> findByEmailId(String emailId);
	List<User> findByPhone(long phone);

}
