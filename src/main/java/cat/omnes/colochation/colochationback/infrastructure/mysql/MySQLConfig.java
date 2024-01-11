package cat.omnes.colochation.colochationback.infrastructure.mysql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySQLConfig {
    @Bean
    MySQL mySQL() {
        return new MySQL(
                // "jdbc:mysql://localhost:3306/colochation",
        );
    }
}
