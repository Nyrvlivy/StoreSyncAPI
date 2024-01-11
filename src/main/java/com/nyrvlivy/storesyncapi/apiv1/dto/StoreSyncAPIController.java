package com.nyrvlivy.storesyncapi.apiv1.dto;

import com.nyrvlivy.storesyncapi.business.service.ProductService;
import com.nyrvlivy.storesyncapi.business.service.StoreSyncAPIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "StoreSyncAPI")
public class StoreSyncAPIController {

    private final StoreSyncAPIService apiService;
    private final ProductService productService;


    @Operation(summary = "Save new products from API", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search operation successful"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @PostMapping("/api")
    public ResponseEntity<List<ProductsDTO>> saveApiProducts() {
        return ResponseEntity.ok(apiService.getAllProducts());
    }

    @Operation(summary = "Save new products", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save product operation successful"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @PostMapping("/")
    public ResponseEntity<ProductsDTO> saveProducts(@RequestBody ProductsDTO productsDTO) {
        return ResponseEntity.ok(productService.saveProductDTO(productsDTO));
    }

    @Operation(summary = "Update products", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update product operation successful"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "422", description = "Invalid request data."),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @PutMapping("/")
    public ResponseEntity<ProductsDTO> updateProduct(@RequestParam("id") String id, @RequestBody ProductsDTO productsDTO) {
        return ResponseEntity.ok(productService.updateProduct(id, productsDTO));
    }

    @Operation(summary = "Delete products by title", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete product operation successful"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "422", description = "Invalid request data."),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @DeleteMapping("/")
    public ResponseEntity<Void> deleteProductByTitle(@RequestParam("title") String title) {
        productService.deleteProductByTitle(title);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Get all products", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all products operation successful"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @GetMapping("/")
    public ResponseEntity<List<ProductsDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(summary = "Get products by title", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update product operation successful"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "422", description = "Invalid request data."),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @GetMapping("/{title}")
    public ResponseEntity<ProductsDTO> getProductByTitle(@PathVariable ("title") String title) {
        return ResponseEntity.ok(productService.getProductByTitle(title));
    }


}
