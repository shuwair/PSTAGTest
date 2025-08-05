package org.pstag.filter;

import java.time.LocalDate;

public class FilterCriteria {
    private String brand;
    private Double maxPrice;
    private LocalDate releaseDateAfter;

    public FilterCriteria(String brand, Double maxPrice, LocalDate releaseDateAfter) {
        this.brand = brand;
        this.maxPrice = maxPrice;
        this.releaseDateAfter = releaseDateAfter;
    }

    public String getBrand() { return brand; }
    public Double getMaxPrice() { return maxPrice; }
    public LocalDate getReleaseDateAfter() { return releaseDateAfter; }
}
