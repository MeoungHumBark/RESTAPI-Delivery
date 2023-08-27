package FoodDeliveryApp.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {
    private final FoodService foodService;
    
    @Autowired
    public FoodController (FoodService foodService){
        this.foodService = foodService;
    }

    @GetMapping()
    ResponseEntity<List<FoodDTO>> getAllFoods()  {
        if (foodService.getAll()==null) {
            return ResponseEntity.notFound().build();
        }
        List<FoodDTO> allFood = foodService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(allFood);
    }

    @GetMapping("{id}")
    ResponseEntity<FoodDTO> getFood(@PathVariable Integer id) {
        if (foodService.get(id)==null) {
            return ResponseEntity.notFound().build();
        }
        FoodDTO selectedFood = foodService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(selectedFood);
    }

    @PostMapping()
    ResponseEntity<FoodDTO> setFood(@RequestBody FoodDTO foodDTO) {
        foodService.set(foodDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(foodDTO);
    }

    @PutMapping("{id}")
    ResponseEntity<FoodDTO> updateFood(@PathVariable Integer id, @RequestBody FoodDTO foodDTO) {
        if (foodService.get(id)==null) {
            return ResponseEntity.notFound().build();
        }
        foodService.update(id,foodDTO);
        return ResponseEntity.status(HttpStatus.OK).body(foodDTO);
    }

    @DeleteMapping()
    ResponseEntity<String> delAllFood()  {
        foodService.delAll();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
    }

    @DeleteMapping ("{id}")
    ResponseEntity<String> deleteFood(@PathVariable Integer id) {
        if (foodService.get(id)==null) {
            return ResponseEntity.notFound().build();
        }
        foodService.del(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
    }

}