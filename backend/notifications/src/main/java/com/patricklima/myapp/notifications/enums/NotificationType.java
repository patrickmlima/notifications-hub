package com.patricklima.myapp.notifications.enums;

public enum NotificationType {
	SMS("SMS"),
	EMAIL("Email"),
	PUSH_NOTIFICATION("PushNotification");
	
	private final String text;

	NotificationType(final String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
	
	public String getType() {
		return text;
	}
}
