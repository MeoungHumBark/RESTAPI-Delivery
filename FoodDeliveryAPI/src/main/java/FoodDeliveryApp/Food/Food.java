package FoodDeliveryApp.Food;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
@Entity
@Table(name="food")
public class Food {
   @Id
   @Column(name="foodno", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @Column(name = "fname")
    private String name;

    @Column(name = "fprice")
    private int price;
}
