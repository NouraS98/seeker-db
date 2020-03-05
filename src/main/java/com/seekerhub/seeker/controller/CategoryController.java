package com.seekerhub.seeker.controller;

import com.seekerhub.seeker.dto.Category.CategoryDto;
import com.seekerhub.seeker.service.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity create(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }

    @GetMapping("find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

//    @GetMapping("category_type/{category_type}")
//    public ResponseEntity findByCategory_type(@PathVariable String category_type){
//        return ResponseEntity.ok(categoryService.findByCategory_type(category_type));
//    }
}
