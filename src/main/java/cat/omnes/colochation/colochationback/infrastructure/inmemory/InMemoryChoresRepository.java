package cat.omnes.colochation.colochationback.infrastructure.inmemory;

import cat.omnes.colochation.colochationback.domain.Chore;
import cat.omnes.colochation.colochationback.domain.ChoresRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

public class InMemoryChoresRepository implements ChoresRepository {

    private final Set<Chore> chores = new HashSet<>(
            Set.of(
                    new Chore(UUID.randomUUID(), "Faire la vaisselle", "to_do", "Nathan"),
                    new Chore(UUID.randomUUID(), "Nettoyer la salle de bain", "to_do", "Nathan"),
                    new Chore(UUID.randomUUID(), "Passer l'aspirateur", "to_do", "Theo")
            )
    );

    @Override
    public List<Chore> findAll() {
        return this.chores.stream().toList();
    }

    @Override
    public Chore add(Chore chore) {
        this.chores.add(chore);
        return chore;
    }

    @Override
    public Optional<Chore> update(Chore chore) {
        return this.find(chore.id)
                .map(c -> {
                    this.chores.remove(c);
                    this.chores.add(chore);
                    return chore;
                });
    }

    @Override
    public Optional<Chore> find(UUID id) {
        return this.chores.stream().filter(c -> c.id.equals(id)).findFirst();
    }
}
