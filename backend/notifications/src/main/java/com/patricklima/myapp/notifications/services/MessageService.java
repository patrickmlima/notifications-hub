package com.patricklima.myapp.notifications.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.patricklima.myapp.notifications.dto.CreateMessageRequest;
import com.patricklima.myapp.notifications.entities.Category;
import com.patricklima.myapp.notifications.entities.Message;
import com.patricklima.myapp.notifications.entities.MessageDispatch;
import com.patricklima.myapp.notifications.entities.Subscription;
import com.patricklima.myapp.notifications.entities.User;
import com.patricklima.myapp.notifications.entities.UserChannel;
import com.patricklima.myapp.notifications.repositories.MessageDispatchRepository;
import com.patricklima.myapp.notifications.repositories.MessageRepository;
import com.patricklima.myapp.notifications.repositories.SubscriptionRepository;
import com.patricklima.myapp.notifications.repositories.UserChannelRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private UserChannelRepository userChannelRepository;

	@Autowired
	private MessageDispatchRepository messageDispatchRepository;

	public Message createMessage(CreateMessageRequest request) {
		Message message = new Message();

		Category category = new Category();
		category.setId(request.categoryId);

		message.setCategory(category);
		message.setBody(request.body);

		message = messageRepository.save(message);

		List<Subscription> subscriptions = subscriptionRepository.findByCategoryId(request.categoryId);

		for (Subscription subscription : subscriptions) {
			User user = subscription.getUser();
			List<UserChannel> userChannels = userChannelRepository.findByUserId(user.getId());

			for (UserChannel channel : userChannels) {
				MessageDispatch dispatch = new MessageDispatch(message.getId(), user.getId(), channel.getChannel().getId());
				dispatch.setUser(user);
				dispatch.setChannel(channel.getChannel());
				dispatch.setMessage(message);
				messageDispatchRepository.save(dispatch);
			}
		}

		return message;
	}
	
	public List<Message> getMessages() {
		return messageRepository.findAll();
	}
}
