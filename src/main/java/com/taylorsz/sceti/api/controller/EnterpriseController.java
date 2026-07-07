package com.taylorsz.sceti.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taylorsz.sceti.api.dto.CreateEnterpriseDTO;
import com.taylorsz.sceti.api.mapper.EnterpriseMapper;
import com.taylorsz.sceti.core.domain.Enterprise;
import com.taylorsz.sceti.core.service.EnterpriseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/enterprise")
@RequiredArgsConstructor
public class EnterpriseController {

  private final EnterpriseService enterpriseService;
  private final EnterpriseMapper enterpriseMapper;

  @PostMapping("/create")
  public ResponseEntity<CreateEnterpriseDTO> create(@Valid @RequestBody CreateEnterpriseDTO dto) {
    Enterprise enterprise = enterpriseMapper.toEnterprise(dto);
    CreateEnterpriseDTO response = enterpriseMapper.toEnterpriseDTO(enterpriseService.create(enterprise));
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
