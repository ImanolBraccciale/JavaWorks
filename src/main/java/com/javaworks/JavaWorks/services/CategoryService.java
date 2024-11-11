package com.javaworks.JavaWorks.services;

import com.javaworks.JavaWorks.models.Category;
import com.javaworks.JavaWorks.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {

        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }



    /*
    public Category getCategoryById(Long id) {
        return categoryRepository.findAllById(id)
    }
*/

}
