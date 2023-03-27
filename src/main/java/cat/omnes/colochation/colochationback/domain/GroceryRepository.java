package cat.omnes.colochation.colochationback.domain;

import java.util.List;

public interface GroceryRepository {
    List<Grocery> load();
}
