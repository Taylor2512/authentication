package com.monodev.authentication.models.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RefreshTokens")
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @ManyToOne
    private Usuario usuario;
    
    @Column(length = 100)
    private String token;
    
    @Column
    private LocalDateTime expiryDate;
    
    public RefreshToken() {
        // Default constructor required by JPA
    }
    
     
    
     
}
