package com.patricklima.myapp.notifications.database.seeders;

import java.util.List;
import java.util.Random;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.patricklima.myapp.notifications.entities.Category;
import com.patricklima.myapp.notifications.entities.NotificationChannel;
import com.patricklima.myapp.notifications.entities.Subscription;
import com.patricklima.myapp.notifications.entities.User;
import com.patricklima.myapp.notifications.entities.UserChannel;
import com.patricklima.myapp.notifications.enums.NotificationType;
import com.patricklima.myapp.notifications.repositories.CategoryRepository;
import com.patricklima.myapp.notifications.repositories.NotificationChannelRepository;
import com.patricklima.myapp.notifications.repositories.SubscriptionRepository;
import com.patricklima.myapp.notifications.repositories.UserChannelRepository;
import com.patricklima.myapp.notifications.repositories.UserRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private NotificationChannelRepository notificationChannelRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	@Autowired
	private UserChannelRepository userChannelRepository;
	
	private static final Logger log = LoggerFactory.getLogger(DatabaseSeeder.class);
	
	private final int USERS_COUNT = 7;
	
	
	private void createCategories() {
		categoryRepository.save(new Category("Sports"));
		categoryRepository.save(new Category("Finance"));
		categoryRepository.save(new Category("Movies"));
	}
	
	private void createChannels() {
		notificationChannelRepository.save(new NotificationChannel(NotificationType.SMS.getType()));
		notificationChannelRepository.save(new NotificationChannel(NotificationType.EMAIL.getType()));
		notificationChannelRepository.save(new NotificationChannel(NotificationType.PUSH_NOTIFICATION.getType()));
	}
	
	private void createUsers(int initialSize) {
		final String[] FIRST_NAMES = {"John", "Jane", "Alice", "Bob", "Charlie", "Dave", "Eve"};
	    final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller"};
	    final String DOMAIN = "@example.com";
	    
	    Random random = new Random();
	    
	    List<Category> categories = categoryRepository.findAll();
	    int numberOfCategories = categories.size();
	    
	    List<NotificationChannel> channels = notificationChannelRepository.findAll();
	    int numberOfChannels = channels.size();
	    
	    for (int i = initialSize; i < 7; i++) {
	    	String name = FIRST_NAMES[i] + " " + LAST_NAMES[i];
	    	String email = FIRST_NAMES[i].toLowerCase() + "." + LAST_NAMES[i].toLowerCase() + DOMAIN;
	    	StringBuilder phoneNumber = new StringBuilder("+");
	    	for (int j = 0; j < 13; j++) {
	    		int digit = random.nextInt(10);
	    		phoneNumber.append(digit);
	    	}
	    	
	    	User user = new User(name,  email,  phoneNumber.toString());
	    	user = userRepository.save(user);
	    	
	    	
	    	int categoryIndex = random.nextInt(numberOfCategories);
	    	Category category = categories.get(categoryIndex);
	    	Subscription subs = new Subscription(user.getId(), category.getId());
	    	subscriptionRepository.save(subs);
	    	
	    	int channelIndex = random.nextInt(numberOfChannels);
	    	NotificationChannel channel = channels.get(channelIndex);
	    	UserChannel userChannel = new UserChannel(user.getId(), channel.getId());
	    	userChannelRepository.save(userChannel);
	    }
	}
	
	@Override
	public void run(String... args) throws Exception {
		boolean hasSeed = false;
		List<Category> categories = categoryRepository.findAll();
		if (categories.isEmpty()) {			
			createCategories();
			hasSeed = true;
		}
		
		List<NotificationChannel> channels = notificationChannelRepository.findAll();
		if (channels.isEmpty()) {
			createChannels();
			hasSeed = true;
		}
		
		List<User> users = userRepository.findAll();
		if (users.isEmpty() || users.size() < USERS_COUNT) {
			createUsers(users.size());
			hasSeed = true;
		}
		
		if (hasSeed) {
			log.info("Successfully seeder database");
		} else {
			log.info("Skipped seeder");
		}
		
	}

}
