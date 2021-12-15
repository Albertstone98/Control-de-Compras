package com.example.controldecompras.entidades;

import java.util.Date;
import java.util.List;

public class Compra {
    private int idCompra;
    private Date fecha;
    private List<Producto> productos;

    public Compra(){}

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
