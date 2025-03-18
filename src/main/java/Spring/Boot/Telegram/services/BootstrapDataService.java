package Spring.Boot.Telegram.services;

import Spring.Boot.Telegram.entities.Chat;
import Spring.Boot.Telegram.entities.Message;
import Spring.Boot.Telegram.entities.User;
import Spring.Boot.Telegram.repositories.ChatRepository;
import Spring.Boot.Telegram.repositories.MessageRepository;
import Spring.Boot.Telegram.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BootstrapDataService implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setUsername("user1");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("user2");
        userRepository.save(user2);

        Chat chat = new Chat();
        chat.setName("General Chat");

        Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);
        chat.setUsers(users);

        chatRepository.save(chat);

        Message message1 = new Message();
        message1.setContent("Hello from User1");
        message1.setUser(user1);
        message1.setChat(chat);
        messageRepository.save(message1);

        Message message2 = new Message();
        message2.setContent("Hello from User2");
        message2.setUser(user2);
        message2.setChat(chat);
        messageRepository.save(message2);

        System.out.println("Bootstrap data initialized successfully!");
    }
}
