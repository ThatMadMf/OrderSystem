package org.example.product;

import org.example.Main;
import org.example.config.DataBaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@SpringBootTest(classes = {Main.class, DataBaseConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ProductRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testGetProductById() {
        Product actualResult = productRepository.getProductById(1);
        assertNotNull(actualResult);
        assertEquals(actualResult.getId(), 1);
    }
}