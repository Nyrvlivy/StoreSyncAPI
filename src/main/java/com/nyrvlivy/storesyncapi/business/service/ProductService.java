package com.nyrvlivy.storesyncapi.business.service;

import com.nyrvlivy.storesyncapi.apiv1.dto.ProductsDTO;
import com.nyrvlivy.storesyncapi.business.converter.ProductConverter;
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
    private final ProductConverter productConverter;

    public ProductsDTO getProductByTitle(String title) {
        try {
            return productConverter.toDTO(productRepository.findByTitle(title));
        } catch (Exception e) {
            throw new RuntimeException(format("Error while getting product by title", title), e);
        }
    }

    public List<ProductsDTO> getAllProducts() {
        try {
            return productConverter.toListDTO(productRepository.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Error while getting all products" + e);
        }
    }

    public ProductEntity saveProduct(ProductEntity productEntity) {
        try {
            return productRepository.save(productEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving product" + e);
        }
    }

    public ProductsDTO saveProductDTO(ProductsDTO productsDTO) {
        try {
            ProductEntity productEntity = productConverter.toEntity(productsDTO);
            return productConverter.toDTO(productRepository.save(productEntity));
        } catch (Exception e) {
            throw new RuntimeException("Error while saving product" + e);
        }
    }

    public void deleteProductByTitle(String title) {
        try {
            productRepository.deleteByTitle(title);
        } catch (Exception e) {
            throw new RuntimeException(format("Error while deleting product by title", title), e);
        }
    }

    public Boolean existsByTitle(String title) {
        try {
            return productRepository.existsByTitle(title);
        } catch (Exception e) {
            throw new RuntimeException(format("Error while checking if product exists", title), e);
        }
    }

    public ProductsDTO updateProduct(String id, ProductsDTO productsDTO) {
        try {
            ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
            saveProduct(productConverter.toEntityUpdate(productEntity, productsDTO, id));
            return productConverter.toDTO(productRepository.findByTitle(productEntity.getTitle()));
        } catch (Exception e) {
            throw new RuntimeException(format("Error while updating product", id), e);
        }
    }
}