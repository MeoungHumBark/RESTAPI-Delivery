package FoodDeliveryApp.Food;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class FoodDTO {

    private int id;

    private String name;

    private int price;

}
