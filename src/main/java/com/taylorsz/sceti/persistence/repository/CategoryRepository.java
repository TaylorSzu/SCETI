package com.taylorsz.sceti.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taylorsz.sceti.core.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
