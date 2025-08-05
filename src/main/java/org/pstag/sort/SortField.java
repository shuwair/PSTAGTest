package org.pstag.sort;

public enum SortField {
    RELEASE_DATE(new SortByReleaseDate()),
    PRICE(new SortByPrice()),
    TYPE_AND_CURRENCY(new SortByTypeCurrency()),
    CUSTOM(null); // custom is handled manually

    private final CarSortStrategy strategy;

    SortField(CarSortStrategy strategy) {
        this.strategy = strategy;
    }

    public CarSortStrategy getStrategy() {
        return strategy;
    }
}
