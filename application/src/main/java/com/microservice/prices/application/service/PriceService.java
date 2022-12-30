package com.microservice.prices.application.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.microservice.prices.application.ports.api.PricesAPIService;
import com.microservice.prices.application.ports.spi.PricePersistance;
import com.microservice.prices.domain.model.Price;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Transactional
public class PriceService implements PricesAPIService {

    PricePersistance priceRepository;    

    @Override
    public List<Price> getAllPrices() {
        log.debug("getAllPrices()");        
        return priceRepository.getAll();
    }

    @Override
    public Optional<Price> getPrice(LocalDateTime appDate, Long productID, Long brandId) {
        log.debug("getPrice({}, {}, {})", appDate, productID, brandId);

        var prices = priceRepository.findPrices(appDate, productID, brandId);

        return prices.stream().findFirst();
    }
}
