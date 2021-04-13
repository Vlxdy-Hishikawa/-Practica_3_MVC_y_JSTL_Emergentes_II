package com.Vlxdy.modelo;
/**
 *
 * @author Vlxdy Hishikawa
 */
public class Productos {
    private int id;
    private String producto;
    private Double precio;
    private int cantidad;
    
    public Productos()
    {
        id = 0;
        producto = "";
        precio = 0.00;
        cantidad = 0;
    }

    public Productos(int id, String producto, Double precio, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}