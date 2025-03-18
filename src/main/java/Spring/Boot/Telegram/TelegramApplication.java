package Spring.Boot.Telegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "Spring.Boot.Telegram.repositories")
@EntityScan(basePackages = "Spring.Boot.Telegram.entities")
public class TelegramApplication {
	public static void main(String[] args) {
		SpringApplication.run(TelegramApplication.class, args);
	}
}
