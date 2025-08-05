package org.pstag.sort;

import org.pstag.model.Car;
import java.util.Comparator;
import java.util.List;

public interface CarSortStrategy extends Comparator<Car> {


    /**
     * Special sort by user-provided type and currency.
     */
    static void sortByCustomTypeAndCurrency(List<Car> cars, String type, String currency) {

        final String normalizedType = type.toLowerCase();
        final String normalizedCurrency = currency.toUpperCase();

        cars.sort((c1, c2) -> {
            boolean isType1 = c1.getType().equalsIgnoreCase(normalizedType);
            boolean isType2 = c2.getType().equalsIgnoreCase(normalizedType);

            // Bring matching type cars to top
            if (isType1 && !isType2) return -1;
            if (!isType1 && isType2) return 1;
            if (!isType1 && !isType2) return 0;

            // Compare prices by selected currency
            double price1 = c1.getPricesByCurrency().getOrDefault(normalizedCurrency, 0.0);
            double price2 = c2.getPricesByCurrency().getOrDefault(normalizedCurrency, 0.0);
            return Double.compare(price2, price1); // Descending
        });
    }
}

