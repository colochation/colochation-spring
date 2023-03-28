package cat.omnes.colochation.colochationback.domain;

import java.util.List;

public interface GuestsRepository {
    List<Guest> findAll();
}
