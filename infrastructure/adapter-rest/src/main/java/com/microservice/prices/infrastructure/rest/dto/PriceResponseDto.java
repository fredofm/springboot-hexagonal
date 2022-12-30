package com.microservice.prices.infrastructure.rest.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PriceResponseDto {
    private Long productId;
    private Long brandId;
    private Long priceList;    
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
}
