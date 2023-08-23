package FoodDeliveryApp.Food;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class FoodService {
    private final JpaFoodRepository foodRepository;
    @Autowired
    public FoodService (JpaFoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
    public Optional<Food> get(Integer id) {
        return foodRepository.findById(id);
    }

    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    public Food set(Food food) {
        return foodRepository.save(food);
    }
    public ResponseEntity<Food> update(Integer id, Food food) {
        if (!foodRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        food.setId(id);
        Food updatedFood = foodRepository.save(food);
        return ResponseEntity.ok(updatedFood);
    }

    public ResponseEntity<Void> del(Integer id) {
        if (!foodRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        foodRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> delAll() {
        foodRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
