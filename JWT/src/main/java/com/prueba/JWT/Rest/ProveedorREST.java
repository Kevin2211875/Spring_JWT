package com.prueba.JWT.Rest;


import com.prueba.JWT.Model.Proveedor;
import com.prueba.JWT.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ProveedorREST {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping
    private ResponseEntity<List<Proveedor>> getAllProveedores() throws URISyntaxException {
        return ResponseEntity.ok(proveedorRepository.findAll());
    }

    @PostMapping
    private ResponseEntity<Proveedor> saveProveedor(@RequestBody Proveedor proveedor) throws URISyntaxException {

        try {
            Proveedor detalleProveedorGuardado = proveedorRepository.save(proveedor);
            return ResponseEntity.created(new URI("/proveedor/" + proveedor.getId()))
                    .body(detalleProveedorGuardado);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
