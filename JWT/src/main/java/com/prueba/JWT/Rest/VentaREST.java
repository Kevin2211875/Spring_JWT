package com.prueba.JWT.Rest;

import com.prueba.JWT.Model.Venta;
import com.prueba.JWT.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/venta/")
public class VentaREST {

    @Autowired
    private VentaService ventaService;

    private ResponseEntity<List<Venta>> getAllVentas() {
        return ResponseEntity.ok(ventaService.findAll());
    }

    @PostMapping
    private ResponseEntity<Venta> saveTipodocumento(@RequestBody Venta venta) throws URISyntaxException {

        try {
            Venta ventaGuardada = ventaService.save(venta);
            return ResponseEntity.created(new URI("/venta/" + venta.getId()))
                    .body(ventaGuardada);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
