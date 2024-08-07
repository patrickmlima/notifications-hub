package com.patricklima.myapp.notifications.sending;

import com.patricklima.myapp.notifications.entities.MessageDispatch;

public interface NotificationStrategy {
	public void sendNotification(MessageDispatch messageDispatch);
}
