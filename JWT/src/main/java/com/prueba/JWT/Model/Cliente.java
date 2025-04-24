package com.prueba.JWT.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente", schema = "tienda")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 40)
    private String name;
    @Column(nullable = false, length = 15)
    private String numeroDocumento;
    @Column(nullable = false, length = 25)
    private String email;
    @Column(nullable = false, length = 12)
    private String telefono;
    @Column(nullable = false, length = 40)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "idTipoDocumento")
    private Tipodocumento tipodocumento;

    public Cliente() {super();}

    public Cliente(Integer id, String name, String numeroDocumento, String email, String telefono, String direccion, Tipodocumento tipodocumento) {
        super();
        this.id = id;
        this.name = name;
        this.numeroDocumento = numeroDocumento;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipodocumento = tipodocumento;
    }

    public Cliente(String name, String numeroDocumento, String email, String telefono, String direccion, Tipodocumento tipodocumento) {
        super();
        this.name = name;
        this.numeroDocumento = numeroDocumento;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipodocumento = tipodocumento;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Tipodocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTipodocumento(Tipodocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }
}
