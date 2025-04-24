package com.prueba.JWT.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipodocumento", schema = "tienda")
public class Tipodocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String tipo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Tipodocumento(){
        super();
    }

    public Tipodocumento(Integer id, String tipo) {
        super();
        this.id = id;
        this.tipo = tipo;
    }

    public Tipodocumento(String tipo) {
        super();
        this.tipo = tipo;
    }
}