package com.juanjo.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.juanjo.springboot.di.app.springboot_di.models.Product;
import com.juanjo.springboot.di.app.springboot_di.repositories.ProductRepository;

/**
 * Maneja la lógica de negocio relacionada con productos.
 * Interactúa con el repositorio para obtener datos de productos.
 * Puedes añadir lógica adicional aquí, como validaciones o transformaciones de
 * datos.
 * Por ejemplo, aplicar un IVA a los precios de los productos.
 * Esta implementación utiliza un repositorio específico para acceder a los
 * datos
 * de productos.
 */
@Service
public class ProductServiceImpl implements ProductService {
    // Inyecta el repositorio de productos
    private ProductRepository repository;

    /**
     * Constructor que inyecta el repositorio de productos.
     *
     * @param repository Repositorio de productos a utilizar.
     */
    public ProductServiceImpl(@Qualifier("productRepositoryImpl") ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * Método para obtener todos los productos.
     *
     * @return Lista de productos con el precio ajustado con IVA.
     */
    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(product -> {
            // Aquí podrías aplicar alguna lógica adicional si es necesario
            // Por ejemplo, formatear el precio o añadir información adicional
            // Aplicación de IVA del 21%
            Double priceImp = product.getPrice() * 1.21d;

            // De esta forma, no se pierde el principio de inmutabilidad del objeto

            // Product newProduct = new Product(product.getId(), product.getName(),
            // priceImp.longValue());

            // Clonamos el producto original y modificamos el precio
            // para no alterar el original
            Product newProduct = (Product) product.clone();
            newProduct.setPrice(priceImp.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    /**
     * Método para buscar un producto por su ID.
     *
     * @param id ID del producto a buscar.
     * @return Producto encontrado o null si no existe.
     */
    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
