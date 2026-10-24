package com.senai.projeto.controller;

import com.senai.projeto.entity.UsuarioEntity;
import com.senai.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // LISTAR TODOS
    @GetMapping
    public List<UsuarioEntity> listarTodos() {
        return service.listarTodos();
    }

    // SALVAR
    @PostMapping
    public UsuarioEntity salvar(@RequestBody UsuarioEntity usuario) {
        return service.salvarUsuario(usuario);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public UsuarioEntity atualizar(
            @PathVariable Long id,
            @RequestBody UsuarioEntity usuario) {

        return service.atualizarUsuario(id, usuario);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluirUsuario(id);
    }
}
