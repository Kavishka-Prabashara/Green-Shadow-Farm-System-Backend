package com.green.shadow.greenshadowfarmsystembackend.controller;

import com.green.shadow.greenshadowfarmsystembackend.model.Crop;
import com.green.shadow.greenshadowfarmsystembackend.service.impl.CropServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/crops")
public class CropController {

    private final CropServiceImpl cropService;

    public CropController(CropServiceImpl cropService) {
        this.cropService = cropService;
    }

    @PostMapping("/save")
    public ResponseEntity<Crop> saveCrop(
            @RequestParam String commonName,
            @RequestParam(required = false) String cropScientificName,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String cropSeason,
            @RequestParam(required = false) MultipartFile cropImage) throws IOException {

        Crop crop = new Crop();
        crop.setCommonName(commonName);
        crop.setCropScientificName(cropScientificName);
        crop.setCategory(category);
        crop.setCropSeason(cropSeason);

        if (cropImage != null && !cropImage.isEmpty()) {
            crop.setCropImage(cropImage.getBytes());
        }

        return new ResponseEntity<>(cropService.saveCrop(crop), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Crop>> getAllCrops() {
        return ResponseEntity.ok(cropService.getAllCrops());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrop(@PathVariable Long id) {
        cropService.deleteCrop(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Crop> updateCrop(@PathVariable Long id, @RequestBody Crop updatedCrop) {
        return ResponseEntity.ok(cropService.updateCrop(id, updatedCrop));
    }
}
