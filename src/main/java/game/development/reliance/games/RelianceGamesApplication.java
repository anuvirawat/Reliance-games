package game.development.reliance.games;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("game.development.reliance.games.model")
@EnableJpaRepositories("game.development.reliance.games.repository")
public class RelianceGamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelianceGamesApplication.class, args);
	}

}
