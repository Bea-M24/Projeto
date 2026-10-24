package com.senai.projeto.controller;

import com.senai.projeto.entity.ProdutosEntity;
import com.senai.projeto.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutosService service;

    // LISTAR TODOS
    @GetMapping
    public List<ProdutosEntity> listarTodos() {
        return service.listarTodos();
    }

    // BUSCAR PRODUTO POR ID
    @GetMapping("/{id}")
    public ProdutosEntity buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // SALVAR
    @PostMapping
    public ProdutosEntity salvar(@RequestBody ProdutosEntity produto) {
        return service.salvarProduto(produto);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public ProdutosEntity atualizar(
            @PathVariable Long id,
            @RequestBody ProdutosEntity produto) {

        return service.atualizarProduto(id, produto);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluirProduto(id);
    }
}
