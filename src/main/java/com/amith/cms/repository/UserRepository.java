package com.amith.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amith.cms.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    List<User> findByFirstNameIgnoreCase(String firstName);
    List<User> findByLastNameIgnoreCase(String lastName);
    List<User> findByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);
}
	