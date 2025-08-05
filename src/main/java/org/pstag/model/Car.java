package org.pstag.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;
import java.util.*;

@XmlRootElement(name = "car")
public class Car {

    private String brand;
    private String model;
    private String type;
    private LocalDate releaseDate;
    private double basePrice;
    private Map<String, Double> pricesByCurrency = new HashMap<>();

    public Car() {}

    public Car(String brand, String model, String type, LocalDate releaseDate,
               double basePrice, Map<String, Double> pricesByCurrency) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.releaseDate = releaseDate;
        this.basePrice = basePrice;
        this.pricesByCurrency = pricesByCurrency;
    }

    @XmlElement
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @XmlElement
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @XmlElement
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @XmlElement
    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    // For JSON
    public Map<String, Double> getPricesByCurrency() {
        return pricesByCurrency;
    }

    public void setPricesByCurrency(Map<String, Double> pricesByCurrency) {
        this.pricesByCurrency = pricesByCurrency;
    }

    // For XML: wrap the map using a list of CurrencyPrice
    @XmlElementWrapper(name = "pricesByCurrency")
    @XmlElement(name = "price")
    public List<CurrencyPrice> getCurrencyPrices() {
        List<CurrencyPrice> list = new ArrayList<>();
        for (Map.Entry<String, Double> entry : pricesByCurrency.entrySet()) {
            list.add(new CurrencyPrice(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    public void setCurrencyPrices(List<CurrencyPrice> list) {
        if (list != null) {
            pricesByCurrency = new HashMap<>();
            for (CurrencyPrice cp : list) {
                pricesByCurrency.put(cp.getCurrency(), cp.getValue());
            }
        }
    }
}
