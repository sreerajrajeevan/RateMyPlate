package sree.project.RateMyPlate.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private int rating;
    private String reviewText;

    public ReviewDto(int rating, String reviewText) {
        this.rating = rating;
        this.reviewText = reviewText;
    }
}
