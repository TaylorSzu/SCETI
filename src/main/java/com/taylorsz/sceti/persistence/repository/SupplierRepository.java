package com.taylorsz.sceti.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taylorsz.sceti.core.domain.Supplier;
import com.taylorsz.sceti.core.enums.Status;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findByStatus(Status status);
}
