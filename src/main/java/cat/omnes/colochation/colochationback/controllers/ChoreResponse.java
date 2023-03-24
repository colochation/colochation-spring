package cat.omnes.colochation.colochationback.controllers;

import cat.omnes.colochation.colochationback.domain.Chore;

public record ChoreResponse(
        String title,
        String status,
        String assigned
) {
    public static ChoreResponse fromDomain(Chore chore) {
        return new ChoreResponse(chore.title, chore.status, chore.assigned);
    }
}
