package cat.omnes.colochation.colochationback.controllers;

import cat.omnes.colochation.colochationback.domain.ChoresRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chores")
public class ChoresController {

    private final ChoresRepository choresRepository;

    public ChoresController(ChoresRepository choresRepository) {
        this.choresRepository = choresRepository;
    }

    @GetMapping
    public ResponseEntity<List<ChoreResponse>> getChores() {
        return ResponseEntity.ok(choresRepository.findAll().stream().map(ChoreResponse::fromDomain).toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChoreResponse createNewChore(@RequestBody ChoreRequest request) {
        return ChoreResponse.fromDomain(choresRepository.add(request.toDomain()));
    }
}
