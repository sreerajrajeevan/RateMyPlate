package sree.project.RateMyPlate.dto;

import lombok.Data;

@Data
public class RestaurentDto {
    private String restaurantName;
    private String location;

    public RestaurentDto(String restaurantName, String location) {
        this.restaurantName = restaurantName;
        this.location = location;
    }


}
