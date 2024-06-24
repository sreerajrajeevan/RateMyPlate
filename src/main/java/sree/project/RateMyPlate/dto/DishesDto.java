package sree.project.RateMyPlate.dto;

import lombok.Data;

@Data
public class DishesDto {
    private String dishName;
    private String description;
    private double price;

    public DishesDto(String dishName, String description, double price) {
        this.dishName = dishName;
        this.description = description;
        this.price = price;
    }
}
