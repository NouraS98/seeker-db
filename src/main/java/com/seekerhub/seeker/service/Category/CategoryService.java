package com.seekerhub.seeker.service.Category;

import com.seekerhub.seeker.dto.Category.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto projectDto);
    List<CategoryDto> findAll();
    CategoryDto findById(long id);
}
