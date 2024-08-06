package com.patricklima.myapp.notifications.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patricklima.myapp.notifications.entities.UserChannel;
import com.patricklima.myapp.notifications.entities.pks.UserChannelId;

public interface UserChannelRepository extends JpaRepository<UserChannel, UserChannelId> {
	List<UserChannel> findByUser(Long userId);
}
