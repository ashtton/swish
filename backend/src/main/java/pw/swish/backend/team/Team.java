package pw.swish.backend.team;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import pw.swish.backend.transaction.TeamTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class Team {

    @Id private String id;

    private String name;

    private List<UUID> players = new ArrayList<>();

    private List<TeamTransaction> transactions = new ArrayList<>();

}
