package cat.omnes.colochation.colochationback.controllers.chores;

import cat.omnes.colochation.colochationback.domain.Chore;

import java.util.UUID;

public record NewChoreRequest(
        String title,
        String assigned
) {
    public Chore toDomain() {
        return new Chore(UUID.randomUUID(), this.title, "to_do", this.assigned);
    }
}
