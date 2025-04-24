package com.prueba.JWT.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "venta", schema = "tienda")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Double totalVenta;
    @Column(nullable = false)
    private Double ivaVenta;
    @Column(nullable = false)
    private Double valorVenta;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente idCliente;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    public Venta(Integer id, Double totalVenta, Double ivaVenta, Double valorVenta, Cliente idCliente, Usuario idUsuario) {
        this.id = id;
        this.totalVenta = totalVenta;
        this.ivaVenta = ivaVenta;
        this.valorVenta = valorVenta;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
    }

    public Venta(Double totalVenta, Double ivaVenta, Double valorVenta, Cliente idCliente, Usuario idUsuario) {
        super();
        this.totalVenta = totalVenta;
        this.ivaVenta = ivaVenta;
        this.valorVenta = valorVenta;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
    }

    public Venta() {super();}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Double getIvaVenta() {
        return ivaVenta;
    }

    public void setIvaVenta(Double ivaVenta) {
        this.ivaVenta = ivaVenta;
    }

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
