package org.example.product;

import org.example.util.SubmitFailedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void addNewProduct(Product product) {
        try {
            productRepository.addNewProduct(product);

        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            throw new SubmitFailedException("Invalid input while adding new product");
        }
    }
}
