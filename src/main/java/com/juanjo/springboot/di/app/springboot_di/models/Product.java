package com.juanjo.springboot.di.app.springboot_di.models;

public class Product implements Cloneable {
    private long id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Método para obtener una representación en cadena del producto.
     *
     * @return Cadena con los detalles del producto.
     */
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(id, name, price);
            // En caso de que no se pueda clonar, devolvemos un nuevo producto con los
            // mismos valores
        }
    }
}
