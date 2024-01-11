package com.nyrvlivy.storesyncapi.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity(name = "ProductEntity")
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title,", length = 800)
    private String title;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "category")
    private String category;
    @Column(name = "description", length = 800)
    private String description;
    @Column(name = "image")
    private String image;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

}
