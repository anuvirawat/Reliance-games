package game.development.reliance.games.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import game.development.reliance.games.model.GameEvent;

public interface GameEventRepository extends JpaRepository<GameEvent, Long> {

    @Query("SELECT e FROM GameEvent e WHERE e.startTime <= :now AND e.endTime >= :now")
    List<GameEvent> findActiveEvents(@Param("now") LocalDateTime now);
}
