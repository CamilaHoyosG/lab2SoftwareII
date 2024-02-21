/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.huynseda.market.access;
import co.com.hyunseda.market.service.Category;
import co.com.hyunseda.market.service.Product;
import java.util.List;


/**
 *
 * @author camil
 */
public interface ICategoryRepository {
    
    boolean save(Category newCategory);
    Category findById(Long id);
    Category findByName(String name);
    boolean delete(Long id);
    boolean edit(Long Id, Category category);
    List<Category> findAll();
}
