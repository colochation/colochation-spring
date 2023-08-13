package cat.omnes.colochation.colochationback.infrastructure;

import cat.omnes.colochation.colochationback.domain.Chore;
import cat.omnes.colochation.colochationback.domain.ChoresRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryChoresRepository implements ChoresRepository {

    private final Map<UUID, Chore> chores = new HashMap<>(
            Map.of(
                    UUID.randomUUID(), new Chore("Faire la vaisselle", "to_do", "Nathan"),
                    UUID.randomUUID(), new Chore("Nettoyer la salle de bain", "to_do", "Nathan"),
                    UUID.randomUUID(), new Chore("Passer l'aspirateur", "to_do", "Theo")
            )
    );

    @Override
    public List<Chore> findAll() {
        return this.chores.values().stream().toList();
    }

    @Override
    public Chore add(Chore chore) {
        final var id = UUID.randomUUID();
        this.chores.put(id, chore);
        return this.chores.get(id);
    }
}
