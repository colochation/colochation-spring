package cat.omnes.colochation.colochationback.infrastructure.redis;

import cat.omnes.colochation.colochationback.domain.Grocery;
import cat.omnes.colochation.colochationback.domain.GroceryRepository;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPooled;

import java.util.List;

public class RedisGroceryRepository implements GroceryRepository {
    private final JedisPooled redis;

    public RedisGroceryRepository(JedisPooled redis) {
        this.redis = redis;
    }

    @Override
    public List<Grocery> load() {

        throw new UnsupportedOperationException("Not implemented yet");
    }
}
