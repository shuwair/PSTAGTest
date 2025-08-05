package org.pstag.filter;

import org.pstag.model.Car;

public interface CarFilterStrategy {
    boolean matches(Car car);
}