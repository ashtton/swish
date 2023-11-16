package pw.swish.backend.team;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pw.swish.backend.game.repository.GameRepository;

import java.util.List;
import java.util.UUID;

@RestController @RequiredArgsConstructor
public class TeamController {

    private final TeamRepository teamRepository;
    private final GameRepository gameRepository;

    @GetMapping("/team/{id}")
    public ResponseEntity<?> getTeam(@PathVariable(value = "id") String id) {
        Team teamFound = teamRepository.findById(id).block();

        if (teamFound == null) {
            return ResponseEntity.status(404)
                    .body(String.format("Team %s not found,", id));
        }

        return ResponseEntity.ofNullable(teamFound);
    }

    @GetMapping("/team/{id}/schedule")
    public ResponseEntity<?> getSchedule(@PathVariable(value = "id") String id) {
        Team teamFound = teamRepository.findById(id).block();

        if (teamFound == null) {
            return ResponseEntity.status(404)
                    .body(String.format("Team %s not found,", id));
        }

        return ResponseEntity.ofNullable(gameRepository.getGamesByTeamId(id));
    }

    @GetMapping("/teams")
    public List<Team> getTeams(@RequestParam(value = "name", defaultValue = "null") String name) {
        if (name.equals("null")) {
            return teamRepository.findAll().collectList().block();
        }

        return teamRepository.getTeamsByNameStartsWith(name).collectList().block();
    }

    @PostMapping("/teams")
    public ResponseEntity<?> createTeam(@RequestBody Team team) {
        team.setId(UUID.randomUUID().toString());

        if (team.getName() == null) {
            return ResponseEntity.badRequest().body("Must provide 'name'.");
        }

        return ResponseEntity.ofNullable(teamRepository.insert(team).block());
    }
}
