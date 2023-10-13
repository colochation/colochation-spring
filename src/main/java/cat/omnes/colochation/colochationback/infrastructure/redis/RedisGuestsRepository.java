package cat.omnes.colochation.colochationback.infrastructure.redis;

import cat.omnes.colochation.colochationback.domain.Guest;
import cat.omnes.colochation.colochationback.domain.GuestsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisGuestsRepository implements GuestsRepository {
    @Override
    public List<Guest> findAll() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
