package com.amith.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amith.cms.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
	