package com.prueba.JWT.Controller;


import com.prueba.JWT.Model.Cliente;
import com.prueba.JWT.Service.ClienteService;
import com.prueba.JWT.Service.TipodocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "Operaciones CRUD para Clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TipodocumentoService tipodocumentoService;

    @GetMapping
    @Operation(summary = "Obtener todos los clientes", description = "Retorna una lista de clientes")
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente por ID", description = "Retorna un cliente si existe")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        return clienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo cliente", description = "Guarda un nuevo cliente en la base de datos")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.save(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(summary = "Actualizar un cliente", description = "Actualiza los datos de un cliente existente")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteService.findById(cliente.getId());

        return clienteExistente.map(c ->
                ResponseEntity.ok(clienteService.save(cliente))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un cliente", description = "Elimina un cliente por su ID")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteService.findById(id);

        if (cliente.isPresent()) {
            clienteService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}