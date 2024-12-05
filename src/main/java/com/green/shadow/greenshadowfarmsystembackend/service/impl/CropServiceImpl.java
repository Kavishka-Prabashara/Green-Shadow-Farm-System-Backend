package com.green.shadow.greenshadowfarmsystembackend.service.impl;

import com.green.shadow.greenshadowfarmsystembackend.model.Crop;
import com.green.shadow.greenshadowfarmsystembackend.repository.CropRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropServiceImpl {

    private final CropRepository cropRepository;

    public CropServiceImpl(CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }

    public Crop saveCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    public void deleteCrop(Long id) {
        cropRepository.deleteById(id);
    }

    public Crop updateCrop(Long id, Crop updatedCrop) {
        return cropRepository.findById(id)
                .map(crop -> {
                    crop.setCommonName(updatedCrop.getCommonName());
                    crop.setCropScientificName(updatedCrop.getCropScientificName());
                    crop.setCategory(updatedCrop.getCategory());
                    crop.setCropSeason(updatedCrop.getCropSeason());
                    crop.setCropImage(updatedCrop.getCropImage());
                    return cropRepository.save(crop);
                })
                .orElseThrow(() -> new RuntimeException("Crop not found"));
    }
}
