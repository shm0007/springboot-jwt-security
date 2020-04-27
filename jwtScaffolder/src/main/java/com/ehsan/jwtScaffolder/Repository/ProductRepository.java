package com.ehsan.jwtScaffolder.Repository;

import com.ehsan.jwtScaffolder.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByTitle(String title);
}
