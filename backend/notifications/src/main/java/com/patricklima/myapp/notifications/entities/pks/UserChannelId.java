package com.patricklima.myapp.notifications.entities.pks;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserChannelId implements Serializable {

	private static final long serialVersionUID = 3997055978122430556L;

	private Long userId;
	private Long channelId;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserChannelId that = (UserChannelId) o;
		return Objects.equals(userId, that.userId) && Objects.equals(channelId, that.channelId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, channelId);
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
