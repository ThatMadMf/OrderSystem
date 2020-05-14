package org.example.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "product/products";
    }

    @GetMapping("new-product")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Product());

        return "product/new-product";
    }

    @PostMapping("new-product")
    public String processNewProduct(@ModelAttribute Product product, Model model) {

        productService.addNewProduct(product);

        model.addAttribute("success", true);

        return "submission-result";
    }
}
