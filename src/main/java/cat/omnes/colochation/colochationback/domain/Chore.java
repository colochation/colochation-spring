package cat.omnes.colochation.colochationback.domain;

import java.util.Objects;
import java.util.UUID;

public class Chore {
    public final UUID id;
    public final String title;
    public final String status;
    public final String assigned;

    public Chore(UUID id, String title, String status, String assigned) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.assigned = assigned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chore chore = (Chore) o;
        return Objects.equals(id, chore.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Chore done() {
        return new Chore(this.id, this.title, "done", this.assigned);
    }
}
