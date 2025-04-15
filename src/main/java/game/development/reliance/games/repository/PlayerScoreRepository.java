package game.development.reliance.games.repository;

import game.development.reliance.games.model.PlayerScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerScoreRepository extends JpaRepository<PlayerScore, Long> {

    List<PlayerScore> findTop10ByOrderByScoreDesc();

    List<PlayerScore> findTop10ByGameIdOrderByScoreDesc(String gameId);

    @Query("SELECT p FROM PlayerScore p WHERE p.gameId = :gameId AND p.country = :country ORDER BY p.score DESC")
    List<PlayerScore> findTopPlayersByGameIdAndCountry(String gameId, String country);
}