/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.huynseda.market.access;

import co.com.hyunseda.market.service.Category;
import co.com.hyunseda.market.service.Product;
import co.com.hyunseda.market.service.ProductService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author camil
 */
public class CategoryRepository implements ICategoryRepository {
        private Connection conn;
        
        public CategoryRepository(){
            initDatabase();
        }
        
         public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./myDatabase.db"; //Para Linux/Mac
        //String url = "jdbc:sqlite:C:/sqlite/db/myDatabase.db"; //Para Windows
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
        
           private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS categories (\n"
                + "	categoryId integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           
           
    @Override
    public boolean save(Category newCategory) {
        try {
            if(newCategory == null || newCategory.getName().isEmpty())
                return false;
    
        String sql = "INSERT INTO categories(name)"
                + "VALUES (?)";
         PreparedStatement pstmt= conn.prepareStatement(sql);
         pstmt.setString(1, newCategory.getName());
         pstmt.executeUpdate();
         return true;
    } catch (SQLException ex) {
        Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
}

    @Override
    public Category findById(Long id) {
        try{
           
            String sql= "SELECT * FROM categories "
                    + "WHERE categoryId = ?";
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet res = pstmt.executeQuery();
            
            if(res.next()){
                Category cat= new Category();
                cat.setCategoryId(res.getLong("categoryId"));
                cat.setName(res.getString("name"));
                return cat;
            }else{
                return null;
            }
        }catch (SQLException ex){
                    Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
                    }
         return null;
    }  

    @Override
    public boolean delete(Long id) {
        try{
            if(id<=0){
                return false;
            }
            String sql="DELETE FROM categories"
                    + "WHERE categoryId = ?";
            
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            return true;             
        }catch (SQLException ex){
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean edit(Long id, Category category) {
       try{
           if(id <= 0 || category == null){
               return false;
           }
           String sql = "UPDATE categories"
                   + "SET name=?, "
                   + "WHERE categoryId=?";
           
           PreparedStatement pstmt= conn.prepareStatement(sql);
           pstmt.setString(1, category.getName());
           pstmt.setLong(3, id);
           pstmt.executeUpdate();
           return true;        
       }catch (SQLException ex){
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
    }

    @Override
    public List<Category> findAll() {
          List<Category> categories = new ArrayList<>();
        try {

            String sql = "SELECT * FROM categories";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Category newCategory = new Category();
                newCategory.setCategoryId(rs.getLong("categoryId"));
                newCategory.setName(rs.getString("name"));
                

                categories.add(newCategory);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    @Override
    public Category findByName(String name) {
      try {

            String sql = "SELECT * FROM categories "
                    + "WHERE name = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
               Category cat = new Category();
                cat.setCategoryId(res.getLong("CategoryId"));
                cat.setName(res.getString("name"));
               
                return cat;
            } else {
                return null;
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

