package com.patricklima.myapp.notifications.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.patricklima.myapp.notifications.entities.pks.SubscriptionId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "subscriptions")
public class Subscription {

	@EmbeddedId
	private SubscriptionId subscriptionId;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@MapsId("categoryId")
	@JoinColumn(name = "category_id")
	private Category category;

	public Subscription() {
	}

	public Subscription(Long userId, Long categoryId) {
		this.subscriptionId = new SubscriptionId(userId, categoryId);
		this.category = new Category(categoryId);
		this.user = new User(userId);
	}

	public SubscriptionId getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(SubscriptionId subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
