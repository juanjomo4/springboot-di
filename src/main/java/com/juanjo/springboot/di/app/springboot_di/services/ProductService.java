package com.juanjo.springboot.di.app.springboot_di.services;

import java.util.List;

import com.juanjo.springboot.di.app.springboot_di.models.Product;

public interface ProductService {

    /**
     * Método para obtener todos los productos.
     *
     * @return Lista de productos con el precio ajustado con IVA.
     */
    List<Product> findAll();

    /**
     * Método para buscar un producto por su ID.
     *
     * @param id ID del producto a buscar.
     * @return Producto encontrado o null si no existe.
     */
    Product findById(Long id);

}
