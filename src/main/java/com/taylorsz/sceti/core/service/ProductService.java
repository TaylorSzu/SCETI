package com.taylorsz.sceti.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taylorsz.sceti.core.domain.Product;
import com.taylorsz.sceti.core.enums.Status;
import com.taylorsz.sceti.core.exception.NotFoundException;
import com.taylorsz.sceti.persistence.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product save(Product product) {
        if (product.getStockQuantity() < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }
        product.setStatus(Status.ACTIVE);
        return productRepository.save(product);
    }

    public Product update(Product product) {
        Product existingProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + product.getId()));

        if (product.getStockQuantity() < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }
        return productRepository.save(product);
    }

    public List<Product> listAll(Status status) {
        if (status == null) {
            return productRepository.findByStatus(Status.ACTIVE);
        } else {
            return productRepository.findByStatus(status);
        }
    }

    public void delete(long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        existingProduct.setStatus(Status.INACTIVE);
        productRepository.save(existingProduct);
    }
}
