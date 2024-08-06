package com.patricklima.myapp.notifications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patricklima.myapp.notifications.entities.MessageDispatch;
import com.patricklima.myapp.notifications.entities.pks.MessageDispatchId;

public interface MessageDispatchRepository extends JpaRepository<MessageDispatch, MessageDispatchId> {
}
