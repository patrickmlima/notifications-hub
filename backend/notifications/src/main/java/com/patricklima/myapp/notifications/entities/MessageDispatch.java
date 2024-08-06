package com.patricklima.myapp.notifications.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.patricklima.myapp.notifications.entities.pks.MessageDispatchId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "message_dispatches")
public class MessageDispatch {
	@EmbeddedId
	private MessageDispatchId messageDispatchId;

	@ManyToOne
	@MapsId("messageId")
	@JoinColumn(name = "messageId")
	private Message message;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne
	@MapsId("channelId")
	@JoinColumn(name = "channelId")
	private NotificationChannel channel;

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@Column
	private LocalDateTime deliveredAt;

	public MessageDispatchId getMessageDispatchId() {
		return messageDispatchId;
	}

	public void setMessageDispatchId(MessageDispatchId messageDispatchId) {
		this.messageDispatchId = messageDispatchId;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getDeliveredAt() {
		return deliveredAt;
	}

	public void setDeliveredAt(LocalDateTime deliveredAt) {
		this.deliveredAt = deliveredAt;
	}
}
