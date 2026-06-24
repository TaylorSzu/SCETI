package com.taylorsz.sceti.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taylorsz.sceti.core.domain.Product;
import com.taylorsz.sceti.core.enums.ProductStatus;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStatus(ProductStatus status);
}
