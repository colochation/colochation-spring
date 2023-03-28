package cat.omnes.colochation.colochationback.infrastructure;

import cat.omnes.colochation.colochationback.domain.ChoresRepository;
import cat.omnes.colochation.colochationback.domain.Guest;
import cat.omnes.colochation.colochationback.domain.GuestsRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryGuestsRepository implements GuestsRepository {
    private final LocalDateTime today = LocalDateTime
            .now()
            .withMinute(0)
            .withSecond(0);
    final LocalDateTime tomorrow = today.plusDays(1);
    final LocalDateTime inOneWeek = today.plusDays(7);

    private final Map<UUID, Guest> guests_data = new HashMap<>(
            Map.of(
                    UUID.randomUUID(), new Guest("Léa", today.withHour(18)),
                    UUID.randomUUID(), new Guest("Charles", tomorrow.withHour(18)),
                    UUID.randomUUID(), new Guest("Sananes", tomorrow.withHour(23)),
                    UUID.randomUUID(), new Guest("?", inOneWeek.withHour(18)),
                    UUID.randomUUID(), new Guest("?", inOneWeek.withHour(23))
            )
    );

    @Override
    public List<Guest> findAll() {
        return this.guests_data.values().stream().toList();
    }
}
