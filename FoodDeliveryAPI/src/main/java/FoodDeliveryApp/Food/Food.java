package FoodDeliveryApp.Food;

import jakarta.persistence.*;

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

   public int getId() {
       return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
