package com.patricklima.myapp.notifications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patricklima.myapp.notifications.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
