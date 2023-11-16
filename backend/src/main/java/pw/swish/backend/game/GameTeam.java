package pw.swish.backend.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class GameTeam {

    private String teamId;

    private int gamesWon;

    private List<GamePlayer> gamePlayers = new ArrayList<>();

    public GameTeam(String teamId) {
        this.teamId = teamId;
    }

}
