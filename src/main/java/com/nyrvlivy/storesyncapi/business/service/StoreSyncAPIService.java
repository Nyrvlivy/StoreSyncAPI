package com.nyrvlivy.storesyncapi.business.service;

import com.nyrvlivy.storesyncapi.apiv1.dto.ProductsDTO;
import com.nyrvlivy.storesyncapi.business.converter.ProductConverter;
import com.nyrvlivy.storesyncapi.infrastructure.client.StoreSyncAPIClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreSyncAPIService {

    private final StoreSyncAPIClient client;
    private final ProductConverter productConverter;
    private final ProductService productService;

    public List<ProductsDTO> getAllProducts() {
        try {
            List<ProductsDTO> dto = client.getProductList();
            dto.forEach(product -> {
                        Boolean result = productService.existsByTitle(product.getTitle());
                        if (result.equals(false)) {
                            productService.saveProduct(productConverter.toEntity(product));
                        }
                    }
            );
            return productService.getAllProducts();
        } catch (Exception e) {
            throw new RuntimeException("Error while getting and saving products to database");
        }
    }
}
