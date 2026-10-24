package com.senai.projeto.controller;

import com.senai.projeto.entity.ServicosEntity;
import com.senai.projeto.service.ServicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicosController {

    @Autowired
    private ServicosService service;

    // LISTAR TODOS
    @GetMapping
    public List<ServicosEntity> listarTodos() {
        return service.listarTodos();
    }

    // BUSCAR SERVIÇO POR ID
    @GetMapping("/{id}")
    public ServicosEntity buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // SALVAR
    @PostMapping
    public ServicosEntity salvar(@RequestBody ServicosEntity servico) {
        return service.salvarServico(servico);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public ServicosEntity atualizar(
            @PathVariable Long id,
            @RequestBody ServicosEntity servico) {

        return service.atualizarServico(id, servico);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluirServico(id);
    }
}
