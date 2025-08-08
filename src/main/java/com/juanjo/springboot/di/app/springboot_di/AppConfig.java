package com.juanjo.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.juanjo.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.juanjo.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {
    /**
     * Configura el repositorio de productos utilizando una implementación JSON.
     * 
     * @return Una instancia de ProductRepository que utiliza JSON como fuente de
     *         datos.
     */
    @Bean
    @Primary
    ProductRepository productRepository() {
        return new ProductRepositoryJson();
    }
}
