package com.patricklima.myapp.notifications.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patricklima.myapp.notifications.entities.Message;
import com.patricklima.myapp.notifications.entities.MessageDispatch;
import com.patricklima.myapp.notifications.entities.Subscription;
import com.patricklima.myapp.notifications.entities.User;
import com.patricklima.myapp.notifications.entities.UserChannel;
import com.patricklima.myapp.notifications.enums.NotificationType;
import com.patricklima.myapp.notifications.repositories.MessageDispatchRepository;
import com.patricklima.myapp.notifications.repositories.SubscriptionRepository;
import com.patricklima.myapp.notifications.repositories.UserChannelRepository;
import com.patricklima.myapp.notifications.sending.EmailNotificationStrategy;
import com.patricklima.myapp.notifications.sending.NotificationStrategy;
import com.patricklima.myapp.notifications.sending.PushNotificationStrategy;
import com.patricklima.myapp.notifications.sending.SmsNotificationStrategy;

@Service
public class MessageDispatchService {
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private UserChannelRepository userChannelRepository;

	@Autowired
	private MessageDispatchRepository messageDispatchRepository;
	
	public void sendMessageNotifications(Message message) {
		List<Subscription> subscriptions = subscriptionRepository.findByCategoryId(message.getCategory().getId());

		for (Subscription subscription : subscriptions) {
			User user = subscription.getUser();
			List<UserChannel> userChannels = userChannelRepository.findByUserId(user.getId());

			for (UserChannel channel : userChannels) {
				MessageDispatch dispatch = new MessageDispatch(message.getId(), user.getId(), channel.getChannel().getId());
				dispatch.setUser(user);
				dispatch.setChannel(channel.getChannel());
				dispatch.setMessage(message);
				messageDispatchRepository.save(dispatch);
				
				NotificationStrategy notificationStrategy = getMessageNotificationStrategy(dispatch);
				notificationStrategy.sendNotification(dispatch);
				messageDispatchRepository.save(dispatch);
			}
		}
	}
	
	private NotificationStrategy getMessageNotificationStrategy(MessageDispatch messageDispatch) {
		if (messageDispatch.getChannel().getName().equals(NotificationType.EMAIL.getType())) {
			return new EmailNotificationStrategy();
		} 
		if (messageDispatch.getChannel().getName().equals(NotificationType.SMS.getType())) {
			return new SmsNotificationStrategy();
		}
		return new PushNotificationStrategy();
	}
}
