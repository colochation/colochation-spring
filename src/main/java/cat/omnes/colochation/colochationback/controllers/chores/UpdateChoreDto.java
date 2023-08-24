package cat.omnes.colochation.colochationback.controllers.chores;

import cat.omnes.colochation.colochationback.domain.Chore;
import cat.omnes.colochation.colochationback.infrastructure.utils.UuidUtils;

import java.util.Optional;
import java.util.UUID;

public record UpdateChoreDto(
        String id,
        String title,
        String assigned,
        Boolean toDo
) {
    public Optional<Chore> toDomain() {
        return UuidUtils
                .fromString(this.id)
                .map(id -> new Chore(id, this.title, this.toDo ? "to_do" : "done", this.assigned));
    }
}
