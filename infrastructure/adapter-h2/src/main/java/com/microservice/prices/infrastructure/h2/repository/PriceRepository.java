package com.microservice.prices.infrastructure.h2.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservice.prices.infrastructure.h2.entity.PriceEntity;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p where ?1 >= p.startDate AND ?1 <= p.endDate AND p.productId = ?2 AND p.brandId = ?3")     
    List<PriceEntity> findPrices(LocalDateTime data, Long productId, Long brandId, Sort sort);
}