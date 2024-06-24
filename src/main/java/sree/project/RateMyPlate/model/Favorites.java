package sree.project.RateMyPlate.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table
@Data
@AllArgsConstructor
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FavId")
    private int favId;
//    @OneToOne
//    @JoinColumn(name = "Dish Id")
//    private int dishId;
    @ManyToOne
    @JoinColumn(name = "dishid", nullable = false)
    private Dishes dish;
}
