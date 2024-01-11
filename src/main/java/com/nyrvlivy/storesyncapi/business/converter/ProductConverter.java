package com.nyrvlivy.storesyncapi.business.converter;

import com.nyrvlivy.storesyncapi.apiv1.dto.ProductsDTO;
import com.nyrvlivy.storesyncapi.infrastructure.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class ProductConverter {
    public ProductEntity toEntity(ProductsDTO dto) {
        return ProductEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .title(dto.getTitle())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .description(dto.getDescription())
                .image(dto.getImage())
                .creationDate(LocalDateTime.now())
                .build();
    }

    public ProductEntity toEntityUpdate(ProductEntity entity, ProductsDTO dto, String id) {
        return ProductEntity.builder()
                .id(id)
                .title(dto.getTitle() != null ? dto.getTitle() : entity.getTitle())
                .price(dto.getPrice() != null ? dto.getPrice() : entity.getPrice())
                .category(dto.getCategory() != null ? dto.getCategory() : entity.getCategory())
                .description(dto.getDescription() != null ? dto.getDescription() : entity.getDescription())
                .image(dto.getImage() != null ? dto.getImage() : entity.getImage())
                .creationDate(entity.getCreationDate())
                .lastUpdate(LocalDateTime.now())
                .build();
    }

    public ProductsDTO toDTO(ProductEntity entity) {
        return ProductsDTO.builder()
                .entityId(entity.getId())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .category(entity.getCategory())
                .description(entity.getDescription())
                .image(entity.getImage())
                .build();
    }

    public List<ProductsDTO> toListDTO(List<ProductEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}
