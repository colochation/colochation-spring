package cat.omnes.colochation.colochationback.infrastructure.redis;

import cat.omnes.colochation.colochationback.domain.Guest;
import cat.omnes.colochation.colochationback.domain.GuestsRepository;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPooled;

import java.util.List;

public class RedisGuestsRepository implements GuestsRepository {
    private final JedisPooled redis;

    public RedisGuestsRepository(JedisPooled redis) {
        this.redis = redis;
    }

    @Override
    public List<Guest> findAll() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
