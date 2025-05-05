package Spring.Boot.Telegram.repositories;

import Spring.Boot.Telegram.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findByText(String text);

    Chat findByName(String generalChat);

}

