package org.pstag.filter;

import org.pstag.model.Car;

class MaxPriceFilter implements CarFilterStrategy {
    private final Double maxPrice;

    public MaxPriceFilter(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean matches(Car car) {
        return maxPrice == null || car.getBasePrice() <= maxPrice;
    }
}