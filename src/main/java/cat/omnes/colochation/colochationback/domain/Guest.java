package cat.omnes.colochation.colochationback.domain;

import java.time.LocalDateTime;

public class Guest {
    public final String name;
    public final LocalDateTime when;

    public Guest(String name, LocalDateTime when) {
        this.name = name;
        this.when = when;
    }
}
