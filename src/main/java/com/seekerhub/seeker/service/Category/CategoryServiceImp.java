package com.seekerhub.seeker.service.Category;

import com.seekerhub.seeker.dto.Category.CategoryDto;
import com.seekerhub.seeker.entity.Category;
import com.seekerhub.seeker.mapper.CategoryMapper;
import com.seekerhub.seeker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        Category categoryToSave = categoryRepository.save(category);
        return categoryMapper.toDto(categoryToSave);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryMapper.toDtos(categoryRepository.findAll());
    }

    @Override
    public CategoryDto findById(long id) {
        return categoryMapper.toDto(categoryRepository.getOne(id));
    }

//    @Override
//    public List<CategoryDto> findByCategory_type(String category_type) {
//
//        return categoryMapper.toDtos(categoryRepository.findByCategory_type(category_type));
//    }
}
