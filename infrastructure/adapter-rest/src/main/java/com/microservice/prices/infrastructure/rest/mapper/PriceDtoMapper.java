package com.microservice.prices.infrastructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.microservice.prices.domain.model.Price;
import com.microservice.prices.infrastructure.rest.dto.PriceResponseDto;

@Mapper(componentModel = "spring") 
public interface PriceDtoMapper {
    
    @Mapping(source = "productId.id", target = "productId")
    @Mapping(source = "brandId.id", target = "brandId")
    @Mapping(source = "priceList.id", target = "priceList")
    public PriceResponseDto toDto(Price prop);
}
