package com.patricklima.myapp.notifications.entities;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "notification_channels")
public class NotificationChannel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, unique = true)
	private String name;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "channel")
	private Set<UserChannel> userChannels;

	@OneToMany(mappedBy = "channel")
	private Set<MessageDispatch> messageDispatches;
	
	public NotificationChannel() {
	}
	
	public NotificationChannel(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set<UserChannel> getUserChannels() {
		return userChannels;
	}

	public void setUserChannels(Set<UserChannel> userChannels) {
		this.userChannels = userChannels;
	}

	public Set<MessageDispatch> getMessageDispatches() {
		return messageDispatches;
	}

	public void setMessageDispatches(Set<MessageDispatch> messageDispatches) {
		this.messageDispatches = messageDispatches;
	}
}
