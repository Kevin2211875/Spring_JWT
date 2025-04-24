package com.prueba.JWT.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalleventa", schema = "tienda")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idVenta", nullable = false)
    private Venta venta;

    @Column(nullable = false)
    private Integer cantidadProducto;
    @Column(nullable = false)
    private Double valorTotal;
    @Column(nullable = false)
    private Double valorVenta;
    @Column(nullable = false)
    private Double valorIva;

    public DetalleVenta(Integer id, Producto producto, Venta venta, Integer cantidadProducto, Double valorTotal, Double valorVenta, Double valorIva) {
        super();
        this.id = id;
        this.producto = producto;
        this.venta = venta;
        this.cantidadProducto = cantidadProducto;
        this.valorTotal = valorTotal;
        this.valorVenta = valorVenta;
        this.valorIva = valorIva;
    }

    public DetalleVenta() {super();}

    public DetalleVenta(Producto producto, Venta venta, Integer cantidadProducto, Double valorTotal, Double valorVenta, Double valorIva) {
        this.producto = producto;
        this.venta = venta;
        this.cantidadProducto = cantidadProducto;
        this.valorTotal = valorTotal;
        this.valorVenta = valorVenta;
        this.valorIva = valorIva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public Double getValorIva() {
        return valorIva;
    }

    public void setValorIva(Double valorIva) {
        this.valorIva = valorIva;
    }
}