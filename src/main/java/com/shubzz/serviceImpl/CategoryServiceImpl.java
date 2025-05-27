package com.shubzz.serviceImpl;

import com.shubzz.entity.Category;
import com.shubzz.repository.CategoryRepository;
import com.shubzz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public boolean saveCategory(Category category) {
        category.setDeleted(false);
        category.setCreatedBy(1);
        category.setCreatedOn(new Date());
        Category saveCategory = categoryRepo.save(category);
        if(ObjectUtils.isEmpty(saveCategory))
            return false;
        return true;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        return categories;
    }
}
