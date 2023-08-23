package FoodDeliveryApp.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodController {
    private final FoodService foodService;
    
    @Autowired
    public FoodController (FoodService foodService){
        this.foodService = foodService;
    }

    @GetMapping("/foods")
    public List<Food> getAllFoods()  {
        return foodService.getAll();
    }

    @GetMapping("/foods/{id}")
    Optional getFoods(@PathVariable Integer id) {
        return foodService.get(id);
    }

    @PostMapping("/foods")
    ResponseEntity<Food> setFoods(@RequestBody Food food) {
        foodService.set(food);
        return ResponseEntity.status(HttpStatus.CREATED).body(food);
    }

    @PutMapping("/foods/{id}")
    Food update(@PathVariable Integer id, @RequestBody Food food) {
        return foodService.update(id,food).getBody();
    }

    @DeleteMapping("/foods")
    ResponseEntity<Void> delAllFoods()  {
        return foodService.delAll();
    }

    @DeleteMapping ("/foods/{id}")
    ResponseEntity<Void> deleteFoods(@PathVariable Integer id) {
        return foodService.del(id);
    }

}