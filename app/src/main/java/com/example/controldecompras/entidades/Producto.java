package com.example.controldecompras.entidades;

public class Producto {

    private int idProducto;
    private String nombre;
    private double precio;
    private int cant;
    private double subtotal;

    public Producto (){}

    public Producto (int id, String name, double precio, int cant){
        this.idProducto = id;
        this.nombre = name;
        this.precio = precio;
        this.cant = cant;
        this.subtotal = precio * cant;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return nombre + " " + cant + " " + precio + " " + subtotal;
    }
}
