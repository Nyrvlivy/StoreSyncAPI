package com.nyrvlivy.storesyncapi.infrastructure.repositories;

import com.nyrvlivy.storesyncapi.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    Boolean existsByTitle(String title);
}
