package cat.omnes.colochation.colochationback.domain;

import cat.omnes.colochation.colochationback.controllers.ChoreResponse;

import java.util.List;

public interface ChoresRepository {
    List<Chore> findAll();

    Chore add(Chore chore);
}
