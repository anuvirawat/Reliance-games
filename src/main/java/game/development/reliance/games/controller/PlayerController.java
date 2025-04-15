package game.development.reliance.games.controller;


import game.development.reliance.games.model.Player;
import game.development.reliance.games.model.PlayerProgess;
import game.development.reliance.games.model.PlayerScore;
import game.development.reliance.games.repository.PlayerProgressRepository;
import game.development.reliance.games.repository.PlayerRepository;
import game.development.reliance.games.repository.PlayerScoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepo;

    @Autowired
    private PlayerProgressRepository progressRepo;
    
    @Autowired
    private PlayerScoreRepository scoreRepo;


    @PostMapping("/register")
    public Player registerPlayer(@RequestBody Player player) {
        player.setCreationDate(LocalDateTime.now());
        return playerRepo.save(player);
    }

    @PostMapping("/progress")
    public PlayerProgess saveProgress(@RequestBody PlayerProgess progress) {
        progress.setLastActiveTime(LocalDateTime.now());
        return progressRepo.save(progress);
    }
    
    @PostMapping("/submit")
    public String submitScore(@RequestBody PlayerScore score) {
        score.setTimestamp(LocalDateTime.now());
        scoreRepo.save(score);
        return "Score submitted!";
    }

    @GetMapping("/top/global")
    public List<PlayerScore> getGlobalTop(@RequestParam int count) {
        return scoreRepo.findAll()
                .stream()
                .sorted((a, b) -> b.getScore() - a.getScore())
                .limit(count)
                .toList();
    }

    @GetMapping("/top/game")
    public List<PlayerScore> getTopByGame(@RequestParam String gameId, @RequestParam int count) {
        return scoreRepo.findAll()
                .stream()
                .filter(score -> score.getGameId().equals(gameId))
                .sorted((a, b) -> b.getScore() - a.getScore())
                .limit(count)
                .toList();
    }

    @GetMapping("/top/game/country")
    public List<PlayerScore> getTopByGameAndCountry(@RequestParam String gameId, @RequestParam String country, @RequestParam int count) {
        return scoreRepo.findAll()
                .stream()
                .filter(score -> score.getGameId().equals(gameId) && score.getCountry().equalsIgnoreCase(country))
                .sorted((a, b) -> b.getScore() - a.getScore())
                .limit(count)
                .toList();
    }
}