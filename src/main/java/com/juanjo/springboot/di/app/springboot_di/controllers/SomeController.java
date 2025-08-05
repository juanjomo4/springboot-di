package com.juanjo.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.juanjo.springboot.di.app.springboot_di.models.Product;
import com.juanjo.springboot.di.app.springboot_di.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para manejar las peticiones relacionadas con productos.
 * Este controlador utiliza el servicio ProductService para obtener los datos
 * de los productos y devolverlos en las respuestas HTTP.
 */
@RestController
@RequestMapping("/api")
public class SomeController {
    // Inyecta el servicio de productos
    @Autowired
    private ProductService service;
    

    /**
     * Método para listar todos los productos.
     * Este método utiliza el servicio ProductService para obtener la lista de
     * productos.
     *
     * @return Lista de productos.
     */

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    /**
     * Método para obtener un producto por su ID.
     * Este método utiliza el servicio ProductService para buscar un producto.
     *
     * @param id ID del producto a buscar.
     * @return Producto encontrado o null si no existe.
     */

    @GetMapping("/{id}")
    public Product show(@PathVariable long id) {
        return service.findById(id);
    }

}
