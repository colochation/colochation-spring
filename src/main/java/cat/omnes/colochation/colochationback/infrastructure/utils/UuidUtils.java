package cat.omnes.colochation.colochationback.infrastructure.utils;

import java.util.Optional;
import java.util.UUID;

public class UuidUtils {
    public static Optional<UUID> fromString(String uuid) {
        try {
            return Optional.of(UUID.fromString(uuid));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
