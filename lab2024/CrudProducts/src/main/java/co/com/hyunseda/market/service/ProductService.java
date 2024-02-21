package co.com.hyunseda.market.service;


import co.com.huynseda.market.access.IProductRepository;
import co.com.hyunseda.market.service.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class ProductService {


    private IProductRepository repository;
    /**
     * Constructor que inicia la base de datos
     * @author Libardo, Julio
     */

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public boolean saveProduct(String name, String description) {
        
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        
        //Validate product
        if (newProduct.getName().isEmpty() ) {
            return false;
        }

        return repository.save(newProduct);

    }
public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.findAll();

        return products;
    }
    
    public Product findProductById(Long id){
        return repository.findById(id);
    }
    
    public Product findProductByName(String name){
        return repository.findByName(name);
    }
    
    public boolean deleteProduct(Long id){
        return repository.delete(id);
    }

    public boolean editProduct(Long productId, Product prod) {
        
        //Validate product
        if (prod == null || prod.getName().isEmpty() ) {
            return false;
        }
        return repository.edit(productId, prod);
    }
}