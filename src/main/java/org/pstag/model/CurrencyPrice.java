package org.pstag.model;

import jakarta.xml.bind.annotation.XmlElement;

public class CurrencyPrice {

    private String currency;
    private double value;

    public CurrencyPrice() {}

    public CurrencyPrice(String currency, double value) {
        this.currency = currency;
        this.value = value;
    }

    @XmlElement
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @XmlElement
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
