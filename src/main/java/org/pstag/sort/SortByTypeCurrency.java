package org.pstag.sort;

import org.pstag.model.Car;

public class SortByTypeCurrency implements CarSortStrategy {
    @Override
    public int compare(Car c1, Car c2) {
        return Double.compare(
            getPriceByTypeCurrency(c2),
            getPriceByTypeCurrency(c1)
        );
    }

    private double getPriceByTypeCurrency(Car car) {
        return switch (car.getType().toLowerCase()) {
            case "suv" -> car.getPricesByCurrency().getOrDefault("EUR", 0.0);
            case "sedan" -> car.getPricesByCurrency().getOrDefault("JPY", 0.0);
            case "truck" -> car.getPricesByCurrency().getOrDefault("USD", car.getBasePrice());
            default -> car.getBasePrice();
        };
    }
}
