package sree.project.RateMyPlate.model;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Entity
@Table
@Data
@AllArgsConstructor
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewId")
    private int reviewId;
//    @ManyToOne
//    @JoinColumn(name = "Restaurant Id")
//    private int restaurantId;
//    @OneToOne
//    @JoinColumn(name = "Dish Id")
//    private int dishId;
    @Column(name = "Rating")
    private int rating;
    @Column(name = "ReviewText")
    private String reviewText;
    @Column(name = "ReviewDate", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime reviewDate;
}
