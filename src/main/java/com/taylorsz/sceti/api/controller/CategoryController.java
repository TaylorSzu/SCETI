package com.taylorsz.sceti.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taylorsz.sceti.core.domain.Category;
import com.taylorsz.sceti.core.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @PostMapping("/add")
  public ResponseEntity<Category> add(@RequestBody Category category) {
    Category response = categoryService.save(category);
    return ResponseEntity.status(HttpStatus.CREATED).body(category);
  }

  @GetMapping("/list/all")
  public ResponseEntity<List<Category>> listAll() {
    return ResponseEntity.status(HttpStatus.OK).body(categoryService.listAll());
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Void> delete(@RequestParam Long id) {
    categoryService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
