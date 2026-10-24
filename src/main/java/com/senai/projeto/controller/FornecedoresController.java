package com.senai.projeto.controller;

import com.senai.projeto.entity.FornecedoresEntity;
import com.senai.projeto.service.FornecedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedoresController {

    @Autowired
    private FornecedoresService service;

    // LISTAR TODOS
    @GetMapping
    public List<FornecedoresEntity> listarTodos() {
        return service.listarTodos();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public FornecedoresEntity buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // SALVAR
    @PostMapping
    public FornecedoresEntity salvar(@RequestBody FornecedoresEntity fornecedor) {
        return service.salvarFornecedor(fornecedor);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public FornecedoresEntity atualizar(
            @PathVariable Long id,
            @RequestBody FornecedoresEntity fornecedor) {

        return service.atualizarFornecedor(id, fornecedor);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluirFornecedor(id);
    }
}
