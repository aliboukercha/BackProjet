package com.projet.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
