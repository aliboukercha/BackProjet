package com.nab.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nab.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
