/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.huynseda.market.access.Factory;
import co.com.huynseda.market.access.ICategoryRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jose0
 */
public class CategoryServiceTest {
    @Test
    public void testSaveCategory() {
        System.out.println("saveCategory");
        ICategoryRepository reposiitory = Factory.getInstance().getReposiitory("camila");
        CategoryService categoryService = new CategoryService(reposiitory);
        categoryService.saveCategory("Cabello");
        String nameExpected = "Cabello";
        String realName = categoryService.findCategoryByName("Cabello").getName();
        assertEquals(nameExpected, realName);
    }
}
