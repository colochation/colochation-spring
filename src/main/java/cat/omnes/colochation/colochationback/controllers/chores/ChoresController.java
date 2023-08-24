package cat.omnes.colochation.colochationback.controllers.chores;

import cat.omnes.colochation.colochationback.domain.Chore;
import cat.omnes.colochation.colochationback.domain.ChoresRepository;
import cat.omnes.colochation.colochationback.infrastructure.utils.UuidUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/chores")
public class ChoresController {

    private final ChoresRepository choresRepository;

    public ChoresController(ChoresRepository choresRepository) {
        this.choresRepository = choresRepository;
    }

    @GetMapping
    public List<ChoreResponse> getChores(@RequestParam Optional<Boolean> todo) {
        final var chores = choresRepository
                .findAll()
                .stream()
                .map(ChoreResponse::fromDomain);

        return todo
                .map(isToDo -> chores.filter(c -> c.toDo().equals(isToDo)).toList())
                .orElseGet(chores::toList);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChoreResponse createNewChore(@RequestBody NewChoreRequest request) {
        return ChoreResponse.fromDomain(choresRepository.add(request.toDomain()));
    }

    @PatchMapping("/{id}")
    public ChoreResponse updateChoreStatus(@PathVariable String id) {
        return UuidUtils
                .fromString(id)
                .flatMap(choresRepository::find)
                .map(Chore::done)
                .flatMap(choresRepository::update)
                .map(ChoreResponse::fromDomain)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find Chore with id " + id));
    }

    @PutMapping()
    public ChoreResponse updateChore(@RequestBody UpdateChoreDto chore) {
        return chore
                .toDomain()
                .flatMap(choresRepository::update)
                .map(ChoreResponse::fromDomain)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find Chore with id " + chore.id()));
    }
}
