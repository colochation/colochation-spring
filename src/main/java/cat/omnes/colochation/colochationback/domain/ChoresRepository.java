package cat.omnes.colochation.colochationback.domain;

import cat.omnes.colochation.colochationback.controllers.ChoreResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChoresRepository {
    List<Chore> findAll();

    Chore add(Chore chore);

    Optional<Chore> update(Chore chore);

    Optional<Chore> find(UUID id);
}
