package com.amith.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amith.cms.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);
}
	