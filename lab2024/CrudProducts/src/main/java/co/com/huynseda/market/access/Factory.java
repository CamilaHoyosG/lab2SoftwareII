/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.huynseda.market.access;

/**
 *
 * @author camil
 */
public class Factory {
    
    private static Factory instance;
    
    private Factory() {
    }
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }
    
      public IProductRepository getRepository(String type) {

        IProductRepository result = null;

        switch (type) {
            case "default":
                result = new ProductRepository();
                break;
        }

        return result;

    }
      
          public ICategoryRepository getReposiitory(String type) {

        ICategoryRepository result = null;

        switch (type) {
            case "camila":
                result = new CategoryRepository();
                break;
        }

        return result;

    }
}



