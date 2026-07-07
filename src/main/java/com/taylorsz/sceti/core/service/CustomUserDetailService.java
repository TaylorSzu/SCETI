package com.taylorsz.sceti.core.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.taylorsz.sceti.core.domain.Employee;
import com.taylorsz.sceti.core.domain.Enterprise;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

  private final EnterpriseService enterpriseService;
  private final EmployeeService employeeService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Enterprise enterprise = enterpriseService.getByEmail(username);

    if (enterprise != null) {
      return enterprise;
    }

    Employee employee = employeeService.getByEmail(username);

    if (employee != null) {
      return employee;
    }
    throw new UsernameNotFoundException("Username not found");
  }

}
