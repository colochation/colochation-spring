package cat.omnes.colochation.colochationback.infrastructure.redis;

import cat.omnes.colochation.colochationback.domain.Chore;
import cat.omnes.colochation.colochationback.domain.ChoresRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RedisChoresRepository implements ChoresRepository {
    @Override
    public List<Chore> findAll() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Chore add(Chore chore) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Optional<Chore> update(Chore chore) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Optional<Chore> find(UUID id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
