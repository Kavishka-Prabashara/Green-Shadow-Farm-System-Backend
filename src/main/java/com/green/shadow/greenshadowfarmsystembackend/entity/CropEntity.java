package com.green.shadow.greenshadowfarmsystembackend.entity;

import jakarta.persistence.*;

@Entity
public class CropEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; private String commonName;
    private String cropScientificName;
    private String category; private
    String cropSeason;
    @Lob
    private byte[] cropImage; // Getters and Setters
}
