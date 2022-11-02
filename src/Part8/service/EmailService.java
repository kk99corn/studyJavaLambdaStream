package Part8.service;

import Part8.model.User;

public class EmailService {
	public void sendPlayWithFriendsEmail(User user) {
		user.getEmailAddress().ifPresent(email -> System.out.println("sending PLAY email to " + email));
	}

	public void sendMakeMoreFriendsEmail(User user) {
		user.getEmailAddress().ifPresent(email -> System.out.println("sending MAKE email to " + email));
	}

	public void sendVerifyYourEmailEmail(User user) {
		user.getEmailAddress().ifPresent(email -> System.out.println("sending Verify email to " + email));
	}
}
