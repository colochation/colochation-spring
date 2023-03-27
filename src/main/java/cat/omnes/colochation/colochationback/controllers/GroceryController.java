package cat.omnes.colochation.colochationback.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/groceries")
public class GroceryController {
    @GetMapping
    public ResponseEntity<List<GroceryResponse>> fetchGroceryList(){
        List<GroceryResponse> groceryResponses = List.of(new GroceryResponse("nathan", false), new GroceryResponse("théo", true));
        return ResponseEntity.ok(groceryResponses);
    }
}
