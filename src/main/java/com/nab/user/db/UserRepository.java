package com.nab.user.db;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nab.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    default Optional<User> findByUsername(String login) {
        User user = new User();
        user.setName(login);

        List<User> listUsers = this.findAll(Example.of(user));

        return Optional.ofNullable(listUsers.isEmpty() ? null : listUsers.get(0));
    }
}
