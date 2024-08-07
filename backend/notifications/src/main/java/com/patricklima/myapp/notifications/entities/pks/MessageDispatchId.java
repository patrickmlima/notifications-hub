package com.patricklima.myapp.notifications.entities.pks;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class MessageDispatchId implements Serializable {

	private static final long serialVersionUID = 1678171769116423673L;
	private Long messageId;
	private Long userId;
	private Long channelId;
	
	public MessageDispatchId() {}
	
	public MessageDispatchId(Long messageId, Long userId, Long channelId) {
		this.messageId = messageId;
		this.userId = userId;
		this.channelId = channelId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MessageDispatchId that = (MessageDispatchId) o;
		return Objects.equals(messageId, that.messageId) && Objects.equals(userId, that.userId)
				&& Objects.equals(channelId, that.channelId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(messageId, userId, channelId);
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

}
