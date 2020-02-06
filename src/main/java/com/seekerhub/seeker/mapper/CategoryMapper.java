package com.seekerhub.seeker.mapper;


import com.seekerhub.seeker.dto.Category.CategoryDto;
import com.seekerhub.seeker.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDto>{

}


