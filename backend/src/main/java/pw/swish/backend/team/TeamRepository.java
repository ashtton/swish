package pw.swish.backend.team;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TeamRepository extends ReactiveMongoRepository<Team, String> {

    Flux<Team> getTeamsByNameStartsWith(String name);

}
