package cat.omnes.colochation.colochationback.infrastructure.redis;

import cat.omnes.colochation.colochationback.domain.Grocery;
import cat.omnes.colochation.colochationback.domain.GroceryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisGroceryRepository implements GroceryRepository {
    @Override
    public List<Grocery> load() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
