package com.soni.app.registration.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soni.app.registration.entity.User;

public interface UserDTO extends JpaRepository<User, UUID> {

}
