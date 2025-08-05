package com.juanjo.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.juanjo.springboot.di.app.springboot_di.models.Product;

@Primary
@Repository
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor Asus 27 pulgadas", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "Monitor Asus 27 pulgadas", 600L);
    }

}
