package com.juanjo.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.juanjo.springboot.di.app.springboot_di.models.Product;

/**
 * Repositorio para manejar la persistencia de productos.
 * En este caso, simula una base de datos con una lista en memoria.
 * Puedes reemplazarlo por una implementación real que use JPA, JDBC, etc.
 * Buscar, actualizar y eliminar productos.
 */
@Primary
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {

        // Se inicializa con algunos productos de ejemplo
        // En un caso real, esto podría ser una base de datos o una fuente externa
        this.data = Arrays.asList(
                new Product(1, "Memoria", 65L),
                new Product(2, "Procesador", 205L),
                new Product(3, "Placa Base", 134L),
                new Product(4, "Tarjeta Gráfica", 543L));
    }

    /**
     * Método para obtener todos los productos.
     *
     * @return Lista de productos.
     */
    @Override
    public List<Product> findAll() {
        return this.data;
    }

    /**
     * Método para buscar un producto por su ID.
     *
     * @param id ID del producto a buscar.
     * @return Producto encontrado o null si no existe.
     */
    @Override
    public Product findById(Long id) {
        return this.data.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
