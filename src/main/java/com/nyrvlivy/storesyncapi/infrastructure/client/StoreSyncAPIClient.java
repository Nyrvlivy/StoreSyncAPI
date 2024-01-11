package com.nyrvlivy.storesyncapi.infrastructure.client;

import com.nyrvlivy.storesyncapi.apiv1.dto.ProductsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "store-sync-api", url = "${store-sync-api.url:#{null}}")
public interface StoreSyncAPIClient {
    @GetMapping("/products")
    List<ProductsDTO> getProductList();
}
