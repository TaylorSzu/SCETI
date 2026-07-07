package com.taylorsz.sceti.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateEnterpriseDTO(
    @NotBlank(message = "name is required") String name,
    @NotBlank(message = "email is required") String email,
    @NotBlank(message = "cnpj is requered") String cnpj,
    @NotBlank(message = "password is required") String password) {
}
