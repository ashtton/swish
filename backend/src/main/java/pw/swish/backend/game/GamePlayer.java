package pw.swish.backend.game;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class GamePlayer {

    private UUID playerId;

    private boolean active = false;

    private List<GameStat> stats = new ArrayList<>();

}
