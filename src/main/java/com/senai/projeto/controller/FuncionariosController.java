package com.senai.projeto.controller;

import com.senai.projeto.entity.FuncionariosEntity;
import com.senai.projeto.service.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

    @Autowired
    private FuncionariosService service;

    // LISTAR TODOS
    @GetMapping
    public List<FuncionariosEntity> listarTodos() {
        return service.listarTodos();
    }

    // BUSCAR FUNCIONÁRIO POR ID
    @GetMapping("/{id}")
    public FuncionariosEntity buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // SALVAR
    @PostMapping
    public FuncionariosEntity salvar(@RequestBody FuncionariosEntity funcionario) {
        return service.salvarFuncionario(funcionario);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public FuncionariosEntity atualizar(
            @PathVariable Long id,
            @RequestBody FuncionariosEntity funcionario) {

        return service.atualizarFuncionario(id, funcionario);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluirFuncionario(id);
    }
}
