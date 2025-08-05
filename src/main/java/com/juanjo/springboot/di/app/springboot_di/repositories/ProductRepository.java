package com.juanjo.springboot.di.app.springboot_di.repositories;

import java.util.List;

import com.juanjo.springboot.di.app.springboot_di.models.Product;

/**
 * Interfaz para el repositorio de productos.
 * Define los métodos que deben implementarse para manejar la persistencia de
 * productos.
 */
public interface ProductRepository {
    List<Product> findAll();

    Product findById(Long id);
}
