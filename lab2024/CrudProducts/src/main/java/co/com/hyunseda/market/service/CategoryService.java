/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.huynseda.market.access.ICategoryRepository;
import co.com.hyunseda.market.service.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camil
 */
public class CategoryService  {
    
    private ICategoryRepository repository;
    
    public CategoryService(ICategoryRepository repository){
        this.repository = repository;
    }
    
    public boolean saveCategory(String name){
        Category newCategory = new Category();
        newCategory.setName(name);
        
        if(newCategory.getName().isEmpty()){
            return false;
        }
        
        return repository.save(newCategory);
    }


public List<Category> findAllCategories() {
    List<Category> categories = new ArrayList<>();
    categories = repository.findAll();
    
return categories;
    }

public Category findCategoryById(Long id){
        return repository.findById(id);
    }

 public Category findCategoryByName(String name){
        return repository.findByName(name);
    }

public boolean editCategory(Long categoryId, Category cat){
    
    if(cat == null || cat.getName().isEmpty()) {
        return false;
    }
    return repository.edit(categoryId, cat);
}

public boolean deleteCategory(Long id){
    return repository.delete(id);
    }
}
