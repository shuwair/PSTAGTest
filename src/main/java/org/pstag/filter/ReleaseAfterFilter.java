package org.pstag.filter;

import org.pstag.model.Car;

import java.time.LocalDate;

class ReleaseAfterFilter implements CarFilterStrategy {
    private final LocalDate releaseAfter;

    public ReleaseAfterFilter(LocalDate releaseAfter) {
        this.releaseAfter = releaseAfter;
    }

    @Override
    public boolean matches(Car car) {
        return releaseAfter == null || car.getReleaseDate().isAfter(releaseAfter);
    }
}