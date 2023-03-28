package cat.omnes.colochation.colochationback.controllers;

import cat.omnes.colochation.colochationback.domain.GuestsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestsController {

    private final GuestsRepository guests;

    public GuestsController(GuestsRepository guests) {
        this.guests = guests;
    }

    @GetMapping
    public ResponseEntity<List<GuestResponse>> getGuests() {
        return ResponseEntity.ok(this.guests.findAll()
                .stream()
                .map(GuestResponse::fromDomain)
                .toList()
        );
    }
}
