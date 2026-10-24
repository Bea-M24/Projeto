package com.senai.projeto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    // MOSTRA A MENSAGEM DE ERRO MAIS AMIGÁVEL
    // A MENSAGEM SERÁ DEFINIDA NO PACOTE SERVICE
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<?, ?>> tratarIllegalArgumentException(
            IllegalArgumentException erro) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", erro.getMessage()));
    }
}
