package com.prueba.JWT.Controller;

import com.prueba.JWT.Repository.UsuarioRepository;
import com.prueba.JWT.Response.UsuarioResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioResponse> changePassword() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> new UsuarioResponse(usuario.getName(), usuario.getEmail()))
                .toList();
    }
}
