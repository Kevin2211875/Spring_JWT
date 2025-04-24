package com.prueba.JWT.Rest;


import com.prueba.JWT.Model.DetalleVenta;
import com.prueba.JWT.Service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/detalleventas/")
public class DetalleVentaREST {

    @Autowired
    private DetalleVentaService detalleVentaService;


    @GetMapping
    private ResponseEntity<List<DetalleVenta>> getAllDetalleVentas() throws URISyntaxException {
        return ResponseEntity.ok(detalleVentaService.findAll());
    }

    @PostMapping
    private ResponseEntity<DetalleVenta> saveDetalleVenta(@RequestBody DetalleVenta detalleVenta) throws URISyntaxException {

        try {
            DetalleVenta detalleVentaguardado = detalleVentaService.save(detalleVenta);
            return ResponseEntity.created(new URI("/detalleventa/" + detalleVenta.getId()))
                    .body(detalleVentaguardado);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
