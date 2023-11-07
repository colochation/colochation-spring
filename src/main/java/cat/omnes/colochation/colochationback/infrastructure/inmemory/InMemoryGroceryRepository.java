package cat.omnes.colochation.colochationback.infrastructure.inmemory;

import cat.omnes.colochation.colochationback.domain.Grocery;
import cat.omnes.colochation.colochationback.domain.GroceryRepository;

import java.util.List;

public class InMemoryGroceryRepository implements GroceryRepository {

    List<Grocery> groceries = List.of(
            new Grocery("nathan", false),
            new Grocery("théo", false)
    );


    @Override
    public List<Grocery> load() {
        return groceries;
    }
}
