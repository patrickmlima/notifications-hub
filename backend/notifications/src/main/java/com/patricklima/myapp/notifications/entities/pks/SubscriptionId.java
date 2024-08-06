package com.patricklima.myapp.notifications.entities.pks;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class SubscriptionId implements Serializable {

	private static final long serialVersionUID = 8382529455191558668L;

	private Long userId;

	private Long categoryId;

	public SubscriptionId() {
	}

	public SubscriptionId(Long userId, Long categoryId) {
		this.userId = userId;
		this.categoryId = categoryId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		SubscriptionId that = (SubscriptionId) o;
		return Objects.equals(userId, that.userId) && Objects.equals(categoryId, that.categoryId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, categoryId);
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}
