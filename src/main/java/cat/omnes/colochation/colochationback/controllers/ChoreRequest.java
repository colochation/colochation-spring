package cat.omnes.colochation.colochationback.controllers;

import cat.omnes.colochation.colochationback.domain.Chore;

public record ChoreRequest(
        String title,
        String assigned
) {
    public Chore toDomain() {
        return new Chore(this.title, "to_do", this.assigned);
    }
}
