package com.taylorsz.sceti.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taylorsz.sceti.core.domain.Category;
import com.taylorsz.sceti.persistence.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
  private final CategoryRepository categoryRepository;

  public Category save(Category category) {
    return categoryRepository.save(category);
  }

  public List<Category> listAll() {
    return categoryRepository.findAll();
  }

  public void delete(Long id) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("This category not found"));
    categoryRepository.deleteById(id);
  }
}
