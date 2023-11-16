package pw.swish.backend.game;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.*;

@Getter @Setter
public class Game {

    @Id private String id;

    private GameTeam teamOne;

    private GameTeam teamTwo;

    private long scheduledDate;

    private GameState gameState = GameState.SCHEDULED;

    private int gameNumber = 1;

    private Map<Integer, List<GameLog>> logs = new HashMap<>();

    public void createLog(UUID player, String message) {
        List<GameLog> logList = logs.getOrDefault(gameNumber, new ArrayList<>());
        logList.add(new GameLog(player, message, System.currentTimeMillis()));
    }

}
