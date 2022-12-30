package com.microservice.prices.infrastructure.h2.adapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.microservice.prices.application.ports.spi.PricePersistance;
import com.microservice.prices.domain.model.Price;
import com.microservice.prices.infrastructure.h2.mapper.PriceDboMapper;
import com.microservice.prices.infrastructure.h2.repository.PriceRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class PriceH2Adapter implements PricePersistance {
    
    PriceRepository pricesRepository;
    PriceDboMapper priceMapper;

    @Override
    public List<Price> getAll() {
        log.debug("getAll()");
        return pricesRepository.findAll().stream().map(p -> priceMapper.toDomain(p)).collect(Collectors.toList());
    }

    @Override
    public List<Price> findPrices(LocalDateTime appDate, Long productId, Long brandId) {
        log.debug("findPrices(appDate={},productId={},brandId={})", appDate, productId, brandId);
        return pricesRepository.findPrices(appDate, productId, brandId, 
                                           Sort.by("priority").descending())
                               .stream().map(p -> priceMapper.toDomain(p)).collect(Collectors.toList());        
    }
}
