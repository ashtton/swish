package pw.swish.backend.game.controller;

import jakarta.websocket.server.PathParam;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pw.swish.backend.game.Game;
import pw.swish.backend.game.GameTeam;
import pw.swish.backend.game.repository.GameRepository;
import pw.swish.backend.team.TeamRepository;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;

    @Getter @Setter
    public static class TeamSubmission {
        private String teamOne;
        private String teamTwo;
    }

    @PostMapping("/game")
    public ResponseEntity<?> createGame(@RequestBody TeamSubmission teamSubmission) {
        if (teamSubmission.getTeamOne() == null || teamSubmission.getTeamTwo() == null) {
            return ResponseEntity.badRequest().body("A game requires two teams.");
        }

        if (!teamRepository.existsById(teamSubmission.getTeamOne()).block() ||
                !teamRepository.existsById(teamSubmission.getTeamTwo()).block()) {
            return ResponseEntity.badRequest().body("Team not found.");
        }

        Game game = new Game();

        game.setId(UUID.randomUUID().toString());
        game.setTeamOne(new GameTeam(teamSubmission.getTeamOne()));
        game.setTeamTwo(new GameTeam(teamSubmission.getTeamTwo()));

        return ResponseEntity.ofNullable(gameRepository.insert(game).block());
    }

    @PostMapping("/game/<id>/schedule")
    public ResponseEntity<?> scheduleGame(@PathParam(value = "id") String id, @RequestParam("time") long time) {
        Game game = gameRepository.findById(id).block();

        if (game == null) {
            return ResponseEntity.status(404).body("Game not found.");
        }

        game.setScheduledDate(time);
        return ResponseEntity.ofNullable(gameRepository.save(game).block());
    }

    @DeleteMapping("/game/<id>")
    public ResponseEntity<?> deleteGame(@PathParam("id") String id) {
        Game game = gameRepository.findById(id).block();

        if (game == null) {
            return ResponseEntity.status(404).body("Game not found.");
        }

        return ResponseEntity.ofNullable(gameRepository.delete(game));
    }
}
