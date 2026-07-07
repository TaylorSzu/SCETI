package com.taylorsz.sceti.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import com.taylorsz.sceti.api.dto.CreateEnterpriseDTO;
import com.taylorsz.sceti.core.domain.Enterprise;

@Mapper(componentModel = ComponentModel.SPRING)
public interface EnterpriseMapper {
  @Mapping(target = "id", ignore = true)
  Enterprise toEnterprise(CreateEnterpriseDTO dto);

  CreateEnterpriseDTO toEnterpriseDTO(Enterprise enterprise);
}
