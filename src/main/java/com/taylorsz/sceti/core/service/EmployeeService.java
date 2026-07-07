package com.taylorsz.sceti.core.service;

import org.springframework.stereotype.Service;

import com.taylorsz.sceti.core.domain.Employee;
import com.taylorsz.sceti.core.exception.NotFoundException;
import com.taylorsz.sceti.persistence.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
  private final EmployeeRepository employeeRepository;

  public Employee getByEmail(String email) {
    return employeeRepository.findByEmail(email)
        .orElseThrow(() -> new NotFoundException("Enterprise with email " + email + " not found"));
  }
}
