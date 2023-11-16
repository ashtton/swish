package pw.swish.backend.player;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import pw.swish.backend.transaction.TeamTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class Player {

    @Id private String id;

    private String firstName;
    private String lastName;

    private String email;
    private String password;

    private List<TeamTransaction> transactions = new ArrayList<>();
    private UUID activeTeam;

    private List<UUID> gamesPlayed = new ArrayList<>();
}
