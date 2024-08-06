package com.patricklima.myapp.notifications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patricklima.myapp.notifications.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{
}
