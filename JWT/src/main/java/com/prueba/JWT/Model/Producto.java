package com.prueba.JWT.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "producto", schema = "tienda")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idProveedor", nullable = false)
    private Proveedor proveedor;

    @Column(nullable = false)
    private Double ivaCompra;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private Double precioCompra;
    @Column(nullable = false)
    private Double precioVenta;

    public Producto(Integer id, Proveedor proveedor, Double ivaCompra, String nombre, Double precioCompra, Double precioVenta) {
        super();
        this.id = id;
        this.proveedor = proveedor;
        this.ivaCompra = ivaCompra;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public Producto(Proveedor proveedor, Double ivaCompra, String nombre, Double precioCompra, Double precioVenta) {
        super();
        this.proveedor = proveedor;
        this.ivaCompra = ivaCompra;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public Producto() {super();}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Double getIvaCompra() {
        return ivaCompra;
    }

    public void setIvaCompra(Double ivaCompra) {
        this.ivaCompra = ivaCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
}

