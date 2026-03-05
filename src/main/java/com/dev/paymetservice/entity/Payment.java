package com.dev.paymetservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payments", uniqueConstraints = {@UniqueConstraint(columnNames = "idempotencyKey")})
@Getter
@Setter
public class Payment {

      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      private UUID id;

      @Column(nullable = false)
      private Double amount;

      @Column(nullable = false)
      private String currency;

      @Enumerated(EnumType.STRING)
      private PaymentStatus status;

      @Column(nullable = false, unique = true)
      private String idempotencyKey;

      private LocalDateTime createdAt;
      private LocalDateTime updatedAt;

      @PrePersist
      public void prePersist() {
            createdAt = LocalDateTime.now();
            updatedAt = LocalDateTime.now();
      }

      @PreUpdate
      public void preUpdate() {
            updatedAt = LocalDateTime.now();
      }
}
