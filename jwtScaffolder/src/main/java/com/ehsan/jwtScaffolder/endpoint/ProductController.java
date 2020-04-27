package com.ehsan.jwtScaffolder.endpoint;

import com.ehsan.jwtScaffolder.Repository.ProductRepository;
import com.ehsan.jwtScaffolder.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/get")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product p = productRepository.save(product);
        return ResponseEntity.ok(p);
    }
    @GetMapping("/product")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> getProduct(@RequestParam String title){
        System.out.println("HELLO");
        Product p =  productRepository.findByTitle(title);
        System.out.println("WORLD");
        return ResponseEntity.ok(p);
    }

}
