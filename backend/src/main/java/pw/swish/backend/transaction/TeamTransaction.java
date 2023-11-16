package pw.swish.backend.transaction;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class TeamTransaction {

    private UUID player;

    private UUID team;

    private TransactionType type;

    private long date;

    public enum TransactionType {
        ADD, REMOVE;
    }
}
