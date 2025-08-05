package org.pstag.filter;

import org.pstag.model.Car;


public class BrandFilter implements CarFilterStrategy {
    private final String brand;

    public BrandFilter(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean matches(Car car) {
        return brand == null || car.getBrand().equalsIgnoreCase(brand);
    }
}

