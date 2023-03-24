package cat.omnes.colochation.colochationback.domain;

import java.util.List;

public interface ChoresRepository {
    List<Chore> findAll();
}
