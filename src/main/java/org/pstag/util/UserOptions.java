package org.pstag.util;

import org.pstag.sort.SortField;

import java.time.LocalDate;


public class UserOptions {
    private String brand;
    private Double maxPrice;
    private LocalDate releaseAfter;
    private SortField sortField;
    private String customType;
    private String customCurrency;
    private String outputFormat;

    // Getters and setters
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Double getMaxPrice() { return maxPrice; }
    public void setMaxPrice(Double maxPrice) { this.maxPrice = maxPrice; }

    public LocalDate getReleaseAfter() { return releaseAfter; }
    public void setReleaseAfter(LocalDate releaseAfter) { this.releaseAfter = releaseAfter; }

    public SortField getSortField() { return sortField; }
    public void setSortField(SortField sortField) { this.sortField = sortField; }

    public String getCustomType() { return customType; }
    public void setCustomType(String customType) { this.customType = customType; }

    public String getCustomCurrency() { return customCurrency; }
    public void setCustomCurrency(String customCurrency) { this.customCurrency = customCurrency; }

    public String getOutputFormat() { return outputFormat; }
    public void setOutputFormat(String outputFormat) { this.outputFormat = outputFormat; }
}
