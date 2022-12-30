package com.microservice.prices.application.ports.spi;

import java.time.LocalDateTime;
import java.util.List;

import com.microservice.prices.domain.model.Price;

public interface PricePersistance {
    
    List<Price> getAll();

    List<Price> findPrices(LocalDateTime appDate, Long productId, Long brandId);    
}
