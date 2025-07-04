package com.shubzz.serviceImpl;

import com.shubzz.dto.CategoryDto;
import com.shubzz.dto.CategoryResponse;
import com.shubzz.entity.Category;
import com.shubzz.repository.CategoryRepository;
import com.shubzz.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean saveCategory(CategoryDto categoryDto) {
//    Category category = new Category();
//    category.setName(categoryDto.getName());
//    category.setDescription(categoryDto.getDescription());
//    category.setActive(categoryDto.isActive());
    Category category = mapper.map(categoryDto,Category.class);
        category.setDeleted(false);
        category.setCreatedBy(1);
        category.setCreatedOn(new Date());
        Category saveCategory = categoryRepo.save(category);
        if(ObjectUtils.isEmpty(saveCategory))
            return false;
        return true;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDto> categoryDtos=categories.stream().map(cat->mapper.map(cat,CategoryDto.class)).toList();
        return categoryDtos;
    }

    @Override
    public List<CategoryResponse> getActiveCategory() {
        List<Category> categories = categoryRepo.findByActiveTrue();
       List<CategoryResponse> activeCategoryList= categories.stream().map(cat->mapper.map(cat,CategoryResponse.class)).toList();
        return activeCategoryList;
    }
}
