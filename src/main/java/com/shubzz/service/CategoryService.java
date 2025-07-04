package com.shubzz.service;

import com.shubzz.dto.CategoryDto;
import com.shubzz.dto.CategoryResponse;
import com.shubzz.entity.Category;

import java.util.List;

public interface CategoryService {
    boolean saveCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategory();

    List<CategoryResponse> getActiveCategory();
}
