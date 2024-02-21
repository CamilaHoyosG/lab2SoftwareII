/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.huynseda.market.access;

import java.util.List;
import co.com.hyunseda.market.service.Product;
/**
 *
 * @author camil
 */
public interface IProductRepository {
    boolean save(Product newProduct);

    List<Product> findAll();
    boolean edit(Long Id, Product newProduct);
     boolean delete(Long id);
     Product findById(Long id);
     Product findByName(String name);
}
