package sree.project.RateMyPlate.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RestaurantId")
    private int restaurantId;
    @Column(name = "RestaurantName")
    private String restaurantName;
    @Column(name = "Location")
    private String location;
    @Column(name = "CreatedAt", updatable = false, nullable = false)
    private LocalDateTime createdAt;
//    @OneToMany(mappedBy = "restaurant")
//    private List <Dishes> dishesList;
    @PrePersist
    protected void onCreate(){
        createdAt= LocalDateTime.now();
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }





    public Restaurant(int restaurantId, String restaurantName, String location, LocalDateTime createdAt, List<Dishes> dishesList) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.location = location;
        this.createdAt = createdAt;


    }

    public Restaurant() {
    }
}
