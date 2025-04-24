package com.prueba.JWT.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedor", schema = "tienda")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String ciudad;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String nit;

    public Proveedor(Integer id, String ciudad, String direccion, String nombre, String telefono, String nit) {
        super();
        this.id = id;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.nit = nit;
    }

    public Proveedor() {super();}

    public Proveedor(String ciudad, String direccion, String nombre, String telefono, String nit) {
        super();
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.nit = nit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}