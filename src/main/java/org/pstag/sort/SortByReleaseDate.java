package org.pstag.sort;

import org.pstag.model.Car;

public class SortByReleaseDate implements CarSortStrategy {
    @Override
    public int compare(Car c1, Car c2) {
        return c2.getReleaseDate().compareTo(c1.getReleaseDate()); // Desc
    }
}
