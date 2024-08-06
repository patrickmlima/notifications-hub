package com.patricklima.myapp.notifications.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patricklima.myapp.notifications.entities.Subscription;
import com.patricklima.myapp.notifications.entities.pks.SubscriptionId;

public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionId> {
	List<Subscription> findByCategory(Long categoryId);
}
