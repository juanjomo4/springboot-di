package com.juanjo.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juanjo.springboot.di.app.springboot_di.models.Product;

public class ProductRepositoryJson implements ProductRepository {
    private List<Product> list;

    /**
     * Constructor que carga los productos desde un archivo JSON.
     */
    public ProductRepositoryJson() {
        ClassPathResource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    /*
     * Busca un producto por su ID.
     * Si no se encuentra, lanza una excepción.
     */
    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> Long.valueOf(p.getId()).equals(id)).findFirst().orElseThrow();
    }

}
