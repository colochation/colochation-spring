package cat.omnes.colochation.colochationback.infrastructure.inmemory;

import cat.omnes.colochation.colochationback.domain.Grocery;
import cat.omnes.colochation.colochationback.domain.GroceryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public class inMemoryGroceryRepository implements GroceryRepository {

    List<Grocery> groceries = List.of(
            new Grocery("nathan", false),
            new Grocery("théo", false)
    );


    @Override
    public List<Grocery> load() {
        return groceries;
    }
}
