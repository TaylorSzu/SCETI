package com.taylorsz.sceti.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taylorsz.sceti.core.domain.Supplier;
import com.taylorsz.sceti.core.enums.Status;
import com.taylorsz.sceti.persistence.repository.SupplierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public Supplier save(Supplier supplier) {
        supplier.setStatus(Status.ACTIVE);
        return supplierRepository.save(supplier);
    }

    public Supplier update(Supplier supplier) {
        Supplier existingSupplier = supplierRepository.findById(supplier.getId())
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + supplier.getId()));
        return supplierRepository.save(supplier);
    }

    public List<Supplier> listAll(Status status) {
        if (status == null) {
            return supplierRepository.findByStatus(Status.ACTIVE);
        } else {
            return supplierRepository.findByStatus(status);
        }
    }

    public void delete(long id) {
        Supplier existingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
        existingSupplier.setStatus(Status.INACTIVE);
        supplierRepository.save(existingSupplier);
    }
}
