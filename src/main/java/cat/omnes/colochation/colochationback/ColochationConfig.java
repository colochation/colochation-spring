package cat.omnes.colochation.colochationback;

import cat.omnes.colochation.colochationback.domain.ChoresRepository;
import cat.omnes.colochation.colochationback.domain.GroceryRepository;
import cat.omnes.colochation.colochationback.domain.GuestsRepository;
import cat.omnes.colochation.colochationback.infrastructure.inmemory.InMemoryChoresRepository;
import cat.omnes.colochation.colochationback.infrastructure.inmemory.InMemoryGroceryRepository;
import cat.omnes.colochation.colochationback.infrastructure.inmemory.InMemoryGuestsRepository;
import cat.omnes.colochation.colochationback.infrastructure.mysql.MySQL;
import cat.omnes.colochation.colochationback.infrastructure.mysql.MySQLChoresRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;

@Configuration
public class ColochationConfig {

    @Bean
    MySQL mySQL() {
        return new MySQL(
                // "jdbc:mysql://localhost:3306/colochation",
        );
    }
    @Bean
    ChoresRepository choresRepository(MySQL mysql) {
        return new MySQLChoresRepository(mysql);
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
