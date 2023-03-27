package cat.omnes.colochation.colochationback.controllers;

import cat.omnes.colochation.colochationback.domain.Grocery;
import cat.omnes.colochation.colochationback.domain.GroceryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groceries")
public final class GroceryController {
    private final GroceryRepository groceryRepository;

    public GroceryController(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    @GetMapping
    public ResponseEntity<List<GroceryResponse>> fetchGroceryList(){
        final List<Grocery> groceries = this.groceryRepository.load();
        List<GroceryResponse> groceryList = groceries.stream().map(GroceryResponse::fromDomain).toList();
        return ResponseEntity.ok(groceryList);
    }
}
