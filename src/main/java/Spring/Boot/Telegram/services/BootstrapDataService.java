package Spring.Boot.Telegram.services;

import Spring.Boot.Telegram.entities.Chat;
import Spring.Boot.Telegram.entities.Message;
import Spring.Boot.Telegram.entities.User;
import Spring.Boot.Telegram.repositories.ChatRepository;
import Spring.Boot.Telegram.repositories.MessageRepository;
import Spring.Boot.Telegram.repositories.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BootstrapDataService implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;
    private Faker faker = new Faker();
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public void run(String... args) throws Exception {

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUsername(faker.name().username());
            user = userRepository.save(user);
            users.add(user);
        }

        for (int i = 0; i < 50; i++) {
            Chat chat = new Chat();
            chat.setName(faker.book().title());

            List<User> chatUsers = new ArrayList<>();
            while (chatUsers.size() < 10) {
                chatUsers.add(users.get(faker.random().nextInt(users.size())));
            }
            chat.setUsers(chatUsers);

            chat = chatRepository.save(chat);

            for (int j = 0; j < 100; j++) {
                Message message = new Message();
                message.setContent(faker.lorem().sentence());
                User sender = users.get(faker.random().nextInt(users.size()));
                message.setUser(sender);
                message.setChat(chat);
                messageRepository.save(message);
            }
        }
        User user1 = new User();
        user1.setUsername("user1");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("user2");
        userRepository.save(user2);

        Chat chat = new Chat();
        chat.setName("General Chat");

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
        if (userRepository.findByUsername("abildin").isEmpty()) {
            User user = new User();
            user.setUsername("abildin");
            user.setPassword(passwordEncoder.encode("abildin")); // шифруем!
            userRepository.save(user);
        }
        if (userRepository.findByUsername("zhavlon").isEmpty()) {
            User user = new User();
            user.setUsername("zhavlon");
            user.setPassword(passwordEncoder.encode("zhavlon")); // шифруем!
            userRepository.save(user);
        }
        System.out.println("Bootstrap data initialized successfully!");
    }
}
