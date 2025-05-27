package com.shubzz.service;

import com.shubzz.entity.Category;

import java.util.List;

public interface CategoryService {
    boolean saveCategory(Category category);
    List<Category> getAllCategory();
}
