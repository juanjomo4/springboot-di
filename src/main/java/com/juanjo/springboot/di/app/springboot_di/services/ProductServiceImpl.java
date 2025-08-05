package com.juanjo.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.juanjo.springboot.di.app.springboot_di.models.Product;
import com.juanjo.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;

/**
 * Servicio para manejar la lógica de negocio relacionada con productos.
 * Este servicio interactúa con el repositorio para obtener datos de productos.
 * Puedes añadir lógica adicional aquí, como validaciones o transformaciones de
 * datos.
 * Por ejemplo, aplicar un IVA a los precios de los productos.
 */
public class ProductServiceImpl implements ProductService {
    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

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
