package com.taylorsz.sceti.core.domain;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
=======
import com.taylorsz.sceti.core.enums.ProductStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
>>>>>>> feat/product-service
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false, unique = true)
  private String code;
  @Column(nullable = false)
  private String description;
  @Column(nullable = false)
  private int stockQuantity;
  @Column(nullable = false)
<<<<<<< HEAD
  private String status;
=======
  @Enumerated(EnumType.STRING)
  private ProductStatus status;
>>>>>>> feat/product-service
}
