package com.example.unitech.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "currency_rates")
public class CurrencyRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String currencyPair;

    @Column(nullable = false)
    private BigDecimal rate;

    // Other properties, constructors, getters, and setters

    // Get the rate value
    public BigDecimal getRate() {
        return rate;
    }
}
