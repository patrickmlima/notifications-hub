package com.patricklima.myapp.notifications.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.patricklima.myapp.notifications.entities.pks.UserChannelId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_channels")
public class UserChannel {

	@EmbeddedId
	private UserChannelId userChannelId;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;

	@ManyToOne
	@MapsId("channelId")
	@JoinColumn(name = "channelId", referencedColumnName = "id")
	private NotificationChannel channel;

	public UserChannelId getUserChannelId() {
		return userChannelId;
	}

	public void setUserChannelId(UserChannelId userChannelId) {
		this.userChannelId = userChannelId;
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

	public NotificationChannel getChannel() {
		return channel;
	}

	public void setChannel(NotificationChannel channel) {
		this.channel = channel;
	}
}
