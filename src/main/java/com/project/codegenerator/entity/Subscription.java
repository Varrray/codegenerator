package com.project.codegenerator.entity;

import com.project.codegenerator.enums.SubscriptionStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription {
    Long id;
    User user;
    Plan plan;
    SubscriptionStatus status;
    String stripeCustomerId;
    String stripeSubscriptionId;
    Instant currentPeriodStrat;
    Boolean cancelAtPeriodEnd;
    Instant createdAt;
    Instant updatedAt;


}
