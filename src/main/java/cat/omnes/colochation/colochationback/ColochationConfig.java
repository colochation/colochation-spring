package cat.omnes.colochation.colochationback;

import cat.omnes.colochation.colochationback.domain.ChoresRepository;
import cat.omnes.colochation.colochationback.domain.GroceryRepository;
import cat.omnes.colochation.colochationback.domain.GuestsRepository;
import cat.omnes.colochation.colochationback.infrastructure.inmemory.InMemoryChoresRepository;
import cat.omnes.colochation.colochationback.infrastructure.inmemory.InMemoryGroceryRepository;
import cat.omnes.colochation.colochationback.infrastructure.inmemory.InMemoryGuestsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;

@Configuration
public class ColochationConfig {
    @Bean
    ChoresRepository choresRepository(JedisPooled redis) {
        return new InMemoryChoresRepository();
    }

    @Bean
    GuestsRepository guestsRepository(JedisPooled redis) {
        return new InMemoryGuestsRepository();
    }

    @Bean
    GroceryRepository groceryRepository(JedisPooled redis) {
        return new InMemoryGroceryRepository();
    }
}
