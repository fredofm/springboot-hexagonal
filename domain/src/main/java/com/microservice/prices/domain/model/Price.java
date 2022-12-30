package com.microservice.prices.domain.model;

import java.time.LocalDateTime;

import com.microservice.prices.domain.shared.Entity;
import com.microservice.prices.domain.shared.RootAggregate;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Price extends RootAggregate implements Entity<Price>  {
    private PriceId priceId;
    private BrandId brandId;
    private LocalDateTime startDate;    
    private LocalDateTime endDate;
    private PriceList priceList;
    private ProductId productId;
    private Priority priority;
    private Double price;
    private Currency cur;

    @Override
    public boolean sameIdentityAs(Price other) {
        return other != null && this.priceId.sameValueAs(other.priceId);
    }
}
