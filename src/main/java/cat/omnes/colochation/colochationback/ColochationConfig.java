package cat.omnes.colochation.colochationback;

import cat.omnes.colochation.colochationback.domain.ChoresRepository;
import cat.omnes.colochation.colochationback.domain.GroceryRepository;
import cat.omnes.colochation.colochationback.domain.GuestsRepository;
import cat.omnes.colochation.colochationback.infrastructure.redis.RedisChoresRepository;
import cat.omnes.colochation.colochationback.infrastructure.redis.RedisGroceryRepository;
import cat.omnes.colochation.colochationback.infrastructure.redis.RedisGuestsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;

@Configuration
public class ColochationConfig {
    @Bean
    ChoresRepository choresRepository(JedisPooled redis) {
        return new RedisChoresRepository(redis);
    }

    @Bean
    GuestsRepository guestsRepository(JedisPooled redis) {
        return new RedisGuestsRepository(redis);
    }

    @Bean
    GroceryRepository groceryRepository(JedisPooled redis) {
        return new RedisGroceryRepository(redis);
    }
}
