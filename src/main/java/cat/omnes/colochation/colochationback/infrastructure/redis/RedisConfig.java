package cat.omnes.colochation.colochationback.infrastructure.redis;

import cat.omnes.colochation.colochationback.domain.ChoresRepository;
import cat.omnes.colochation.colochationback.domain.GroceryRepository;
import cat.omnes.colochation.colochationback.domain.GuestsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;



// https://redis.io/docs/clients/java/

@Configuration
public class RedisConfig {
    @Bean
    JedisPooled jedisPooled() {
        return new JedisPooled("iac-redis", 6379);
    }
}
