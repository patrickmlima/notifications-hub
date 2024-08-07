package com.patricklima.myapp.notifications.sending;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patricklima.myapp.notifications.entities.MessageDispatch;

public class SmsNotificationStrategy implements NotificationStrategy {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void sendNotification(MessageDispatch messageDispatch) {
		this.log.info("Sending notification though SMS to " + messageDispatch.getUser().getPhoneNumber());
		messageDispatch.setDeliveredAt(LocalDateTime.now());
	}
}
