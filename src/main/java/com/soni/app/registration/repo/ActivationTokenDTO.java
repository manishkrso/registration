package com.soni.app.registration.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soni.app.registration.entity.ActivationToken;

public interface ActivationTokenDTO extends JpaRepository<ActivationToken, UUID> {

}
