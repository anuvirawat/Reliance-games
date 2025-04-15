package game.development.reliance.games.repository;

import game.development.reliance.games.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
