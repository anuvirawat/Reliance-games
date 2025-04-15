package game.development.reliance.games.repository;

import game.development.reliance.games.model.PlayerProgess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerProgressRepository extends JpaRepository<PlayerProgess, Long> {
}