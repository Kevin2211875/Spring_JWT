package com.prueba.JWT.Controller;

public record AuthRequest(
        String email,
        String password
) {
}