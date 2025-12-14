package com.example.mslocation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;
    private Double longitude;
    private LocalDateTime dateHeure;
    private Long userId;

    public Location(){}

    public Location(Double latitude, Double longitude, LocalDateTime dateHeure, Long userId) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateHeure = dateHeure;
        this.userId = userId;
    }

    //Getters
    public Long getUserId() { return userId; }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public Long getId() {
        return id;
    }

    //Setters
    public void setUserId(Long userId) { this.userId = userId; }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
