package cat.omnes.colochation.colochationback.controllers;

import cat.omnes.colochation.colochationback.domain.Guest;

import java.time.LocalDateTime;

public record GuestResponse(
        String name,
        LocalDateTime when
) {
    public static GuestResponse fromDomain(Guest guest) {
        return new GuestResponse(
                guest.name,
                guest.when
        );
    }
}
