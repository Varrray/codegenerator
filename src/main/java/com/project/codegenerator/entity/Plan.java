package com.project.codegenerator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Import the Id annotation
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {
     @Id // Add this
     @GeneratedValue(strategy = GenerationType.IDENTITY) // Recommended for auto-increment
     Long Id;

     String name;
     String stripePriceId;
     Integer maxProjects;
     Integer maxTokenPerDay;
     Integer maxPreviews;
     Boolean unlimitedAi;
     Boolean active;
}