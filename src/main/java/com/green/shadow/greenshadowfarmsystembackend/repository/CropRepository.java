package com.green.shadow.greenshadowfarmsystembackend.repository;

import com.green.shadow.greenshadowfarmsystembackend.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
    // JpaRepository provides built-in CRUD operations
}
