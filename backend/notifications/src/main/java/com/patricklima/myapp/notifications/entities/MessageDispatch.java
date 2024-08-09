package com.patricklima.myapp.notifications.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.patricklima.myapp.notifications.entities.pks.MessageDispatchId;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "message_dispatches")
public class MessageDispatch {
	@EmbeddedId
	private MessageDispatchId messageDispatchId;

	@ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	@MapsId("messageId")
	@JoinColumn(name = "message_id")
	private Message message;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("channelId")
	@JoinColumn(name = "channel_id")
	private NotificationChannel channel;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@Column
	private LocalDateTime deliveredAt;
	
	public MessageDispatch() {}
	
	public MessageDispatch(Long messageId, Long userId, Long channelId) {
		this.messageDispatchId = new MessageDispatchId(messageId, userId, channelId);
	}

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
