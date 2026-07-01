package com.taylorsz.sceti.core.service;

import org.springframework.stereotype.Service;

import com.taylorsz.sceti.core.domain.Enterprise;
import com.taylorsz.sceti.core.exception.EmailAlreadyExistsException;
import com.taylorsz.sceti.core.exception.NotFoundException;
import com.taylorsz.sceti.persistence.repository.EnterpriseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnterpriseService {
    private final EnterpriseRepository enterpriseRepository;

    public Enterprise create(Enterprise enterprise) {
        enterprise.setName(enterprise.getName().toUpperCase());

        if (getById(enterprise.getId()).getEmail().equals(enterprise.getEmail())) {
            throw new EmailAlreadyExistsException("Enterprise with email " + enterprise.getEmail() + " already exists");
        }
        return enterpriseRepository.save(enterprise);
    }

    public Enterprise getById(Long id) {
        return enterpriseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Enterprise with ID " + id + " not found"));
    }
}
