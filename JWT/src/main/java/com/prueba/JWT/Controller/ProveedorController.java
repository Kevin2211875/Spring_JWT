package com.prueba.JWT.Controller;


import com.prueba.JWT.Exception.ResourceNotFoundException;
import com.prueba.JWT.Model.Proveedor;
import com.prueba.JWT.Service.ProveedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/proveedores")
@Tag(name = "Proveedores", description = "Operaciones CRUD para Proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> getAllProveedores(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(proveedorService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar proveedor por ID", description = "Retorna un proveedor si existe")
    public ResponseEntity<Proveedor> findById(@PathVariable Integer id, @RequestHeader("Authorization") String token) {
        return proveedorService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con ID: " + id));
    }

    @PostMapping
    @Operation(summary = "Crear un proveedor", description = "Guarda un nuevo proveedor en la base de datos")
    public ResponseEntity<Proveedor> create(@Valid @RequestBody Proveedor proveedor, @RequestHeader("Authorization") String token) {
        Proveedor nuevoProveedor = proveedorService.save(proveedor);
        return new ResponseEntity<>(nuevoProveedor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un proveedor", description = "Actualiza los datos de un proveedor existente")
    public ResponseEntity<Proveedor> update(@PathVariable Integer id, @Valid @RequestBody Proveedor proveedor) {
        return proveedorService.findById(id)
                .map(p -> {
                    proveedor.setId(id);
                    return ResponseEntity.ok(proveedorService.save(proveedor));
                }).orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con ID: " + id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un proveedor", description = "Elimina un proveedor por su ID")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!proveedorService.existsById(id)) {
            throw new ResourceNotFoundException("Proveedor no encontrado con ID: " + id);
        }
        proveedorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

