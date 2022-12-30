package com.microservice.prices.domain.model;

import com.microservice.prices.domain.shared.ValueObject;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PriceId implements ValueObject<PriceId> {

    private Long id;

    @Override
    public boolean sameValueAs(PriceId other) {
        return other != null && this.id.equals(other.id);
    }
}
