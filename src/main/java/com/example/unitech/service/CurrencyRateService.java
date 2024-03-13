package com.example.unitech.service;

import com.example.unitech.model.CurrencyRate;
import com.example.unitech.repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CurrencyRateService {
    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    public BigDecimal getCurrencyRate(String currencyPair) {
        Optional<CurrencyRate> currencyRateOptional = currencyRateRepository.findByCurrencyPair(currencyPair);
        if (currencyRateOptional.isPresent()) {
            return currencyRateOptional.get().getRate();
        } else {
            throw new IllegalArgumentException("Currency rate not found for currency pair: " + currencyPair);
        }
    }
}

