package com.patricklima.myapp.notifications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patricklima.myapp.notifications.entities.NotificationChannel;

public interface NotificationChannelRepository extends JpaRepository<NotificationChannel, Long> {

}
