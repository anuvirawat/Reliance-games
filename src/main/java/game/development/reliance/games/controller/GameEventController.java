package game.development.reliance.games.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import game.development.reliance.games.model.GameEvent;
import game.development.reliance.games.repository.GameEventRepository;

@RestController
@RequestMapping("/api/events")
public class GameEventController {

    @Autowired
    private GameEventRepository eventRepo;

    @PostMapping("/schedule")
    public ResponseEntity<String> scheduleEvent(@RequestBody GameEvent event) {
        eventRepo.save(event);
        return ResponseEntity.ok("Event scheduled successfully!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEvent(@PathVariable Long id, @RequestBody GameEvent updatedEvent) {
        return eventRepo.findById(id).map(event -> {
            event.setName(updatedEvent.getName());
            event.setStartTime(updatedEvent.getStartTime());
            event.setEndTime(updatedEvent.getEndTime());
            event.setConfiguration(updatedEvent.getConfiguration());
            eventRepo.save(event);
            return ResponseEntity.ok("Event updated successfully!");
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/available")
    public List<GameEvent> getAvailableEvents() {
        return eventRepo.findActiveEvents(LocalDateTime.now());
    }
}
