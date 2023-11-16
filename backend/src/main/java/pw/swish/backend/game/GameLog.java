package pw.swish.backend.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter @Setter
public class GameLog {

    private UUID player;

    private String message;

    private long date;

}
