package sree.project.RateMyPlate.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Table
@Data
@AllArgsConstructor
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DishId")
    private int dishId;
//    @ManyToOne
//    @JoinColumn(name = "Restaurant Id")
//    private int restaurantId;
    @ManyToOne
    @JoinColumn(name = "restaurantid", nullable = false)
    private Restaurant restaurant;
//    @OneToOne(mappedBy = "dishes")
//    private Reviews reviews;
//    @OneToOne(mappedBy = "dishes")
//    private Favorites favorites;
    @Column(name = "DishName")
    private String dishName;
    @Column(name = "Description")
    private String description;
    @Column(name = "Price")
    private double price;
    @Column(name = "CreatedAt", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
}
