package ru.bogatov.VueApp.Entities;

import lombok.Data;

@Data
public class ProductFilter {
    String brandName = "null";
    String productType = "null";
    String minPrice = "null";
    String maxPrice = "null";
    String isSale= "null";
    String sort= "null";
}
