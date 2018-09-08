package com.checklist.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checklist.management.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
