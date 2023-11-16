package pw.swish.backend.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pw.swish.backend.statistic.Statistic;

import java.util.UUID;

@AllArgsConstructor
@Getter @Setter
public class GameStat {

    private UUID id;

    private UUID game;

    private Statistic statistic;

    private long gameNumber;

    private long date;

}
