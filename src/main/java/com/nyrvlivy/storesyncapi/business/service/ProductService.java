package com.nyrvlivy.storesyncapi.business.service;

import com.nyrvlivy.storesyncapi.infrastructure.entities.ProductEntity;
import com.nyrvlivy.storesyncapi.infrastructure.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductEntity saveProduct(ProductEntity productEntity) {
        try {
            return productRepository.save(productEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving product" + e);
        }
    }

    public List<ProductEntity> getAllProducts() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error while getting all products" + e);
        }
    }

    public Boolean existsByTitle(String title) {
        try {
            return productRepository.existsByTitle(title);
        } catch (Exception e) {
            throw new RuntimeException(format("Error while checking if product exists", title), e);
        }
    }
}