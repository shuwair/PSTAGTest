package org.pstag.output;

import org.pstag.model.Car;

import java.util.List;

public class TableOutputPrinter implements CarOutputPrinter {
    @Override
    public void print(List<Car> cars) {
        System.out.printf("%-15s %-15s %-10s %-12s %-10s %-10s %-10s %-12s%n",
                "Brand", "Model", "Type", "ReleaseDate", "USD", "EUR", "GBP", "JPY");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Car car : cars) {
            System.out.printf("%-15s %-15s %-10s %-12s %-10.2f %-10.2f %-10.2f %-12.2f%n",
                    car.getBrand(), car.getModel(), car.getType(),
                    car.getReleaseDate(),
                    car.getPricesByCurrency().getOrDefault("USD", car.getBasePrice()),
                    car.getPricesByCurrency().getOrDefault("EUR", 0.0),
                    car.getPricesByCurrency().getOrDefault("GBP", 0.0),
                    car.getPricesByCurrency().getOrDefault("JPY", 0.0));
        }
    }
}




