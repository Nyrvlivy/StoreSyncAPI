package com.nyrvlivy.storesyncapi.apiv1.dto;

import com.nyrvlivy.storesyncapi.business.service.StoreSyncAPIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "StoreSyncAPI")
public class StoreSyncAPIController {

        private final StoreSyncAPIService service;

        @Operation(summary = "Get all products", method = "GET")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Search operation successful"),
                @ApiResponse(responseCode = "500", description = "Internal server error"),
        })

        @GetMapping("")
        public ResponseEntity<List<ProductsDTO>> getProducts() {
            return ResponseEntity.ok(service.getAllProducts());
        }


}
