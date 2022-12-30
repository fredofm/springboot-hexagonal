package com.microservice.prices.application.ports.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.microservice.prices.domain.model.Price;

public interface PricesAPIService {

    public Optional<Price> getPrice(LocalDateTime appDate, Long productID, Long brandId);

    public List<Price> getAllPrices();
}
