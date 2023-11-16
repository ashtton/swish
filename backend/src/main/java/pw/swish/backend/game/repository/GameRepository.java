package pw.swish.backend.game.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pw.swish.backend.game.Game;
import reactor.core.publisher.Flux;

import java.util.List;

public interface GameRepository extends ReactiveMongoRepository<Game, String> {

    Flux<Game> getGamesByTeamOneTeamIdOrTeamTwoTeamId(String id, String id2);

    default List<Game> getGamesByTeamId(String id) {
        return getGamesByTeamOneTeamIdOrTeamTwoTeamId(id, id).collectList().block();
    }
}
