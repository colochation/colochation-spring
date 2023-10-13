package cat.omnes.colochation.colochationback;

import cat.omnes.colochation.colochationback.domain.ChoresRepository;
import cat.omnes.colochation.colochationback.domain.GroceryRepository;
import cat.omnes.colochation.colochationback.domain.GuestsRepository;
import cat.omnes.colochation.colochationback.infrastructure.RedisGuestsRepository;
import cat.omnes.colochation.colochationback.infrastructure.redis.RedisChoresRepository;
import cat.omnes.colochation.colochationback.infrastructure.redis.RedisGroceryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    ChoresRepository choresRepository() {
        return new RedisChoresRepository();
    }

    @Bean
    GuestsRepository guestsRepository() {
        return new RedisGuestsRepository();
    }

    @Bean
    GroceryRepository groceryRepository() {
        return new RedisGroceryRepository();
    }
}
