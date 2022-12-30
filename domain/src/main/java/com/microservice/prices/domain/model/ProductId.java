package com.microservice.prices.domain.model;

import com.microservice.prices.domain.shared.ValueObject;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductId implements ValueObject<ProductId> {

    private Long id;

    @Override
    public boolean sameValueAs(ProductId other) {
        return other != null && this.id.equals(other.id);
    }
}
