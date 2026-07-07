package com.taylorsz.sceti.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taylorsz.sceti.core.domain.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
  Optional<Enterprise> findByEmail(String email);

  boolean existsByEmail(String email);
}
