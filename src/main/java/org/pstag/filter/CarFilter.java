package org.pstag.filter;

import org.pstag.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarFilter {

    public static List<Car> applyFilters(List<Car> cars, FilterCriteria criteria) {
        List<CarFilterStrategy> strategies = new ArrayList<>();

        strategies.add(new BrandFilter(criteria.getBrand()));
        strategies.add(new MaxPriceFilter(criteria.getMaxPrice()));
        strategies.add(new ReleaseAfterFilter(criteria.getReleaseDateAfter()));

        return cars.stream()
                .filter(car -> strategies.stream().allMatch(strategy -> strategy.matches(car)))
                .collect(Collectors.toList());
    }
}
