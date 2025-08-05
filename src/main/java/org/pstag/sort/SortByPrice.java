package org.pstag.sort;

import org.pstag.model.Car;

public class SortByPrice implements CarSortStrategy {
    @Override
    public int compare(Car c1, Car c2) {
        return Double.compare(c2.getBasePrice(), c1.getBasePrice()); // Desc
    }
}
