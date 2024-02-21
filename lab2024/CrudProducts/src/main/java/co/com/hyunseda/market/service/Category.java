package co.com.hyunseda.market.service;

import co.com.huynseda.market.access.CategoryRepository;
import co.com.huynseda.market.access.ICategoryRepository;
import co.com.huynseda.market.access.IProductRepository;
import co.com.huynseda.market.access.ProductRepository;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Category {
    private Long categoryId;
    private String name;

    public Category(Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Category() {
    }
    


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
