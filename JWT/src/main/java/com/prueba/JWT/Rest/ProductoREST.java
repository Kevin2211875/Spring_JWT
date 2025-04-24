package com.prueba.JWT.Rest;


import com.prueba.JWT.Model.Producto;
import com.prueba.JWT.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/productos/")
public class ProductoREST {

    @Autowired
    private ProductoService productoService;


    @GetMapping
    private ResponseEntity<List<Producto>> getAllProductos(){
        return ResponseEntity.ok(productoService.findAll());
    }

    @PostMapping
    private ResponseEntity<Producto> saveProducto(@RequestBody Producto producto) throws URISyntaxException {

        try {
            Producto productoGuardado = productoService.save(producto);
            return ResponseEntity.created(new URI("/tipodocumento/" + producto.getId()))
                    .body(productoGuardado);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
