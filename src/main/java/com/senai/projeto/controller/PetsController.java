package com.senai.projeto.controller;

import com.senai.projeto.entity.PetsEntity;
import com.senai.projeto.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private PetsService service;

    // LISTAR TODOS
    @GetMapping
    public List<PetsEntity> listarTodos() {
        return service.listarTodos();
    }

    // BUSCAR PET POR ID
    @GetMapping("/{id}")
    public PetsEntity buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // SALVAR
    @PostMapping
    public PetsEntity salvar(@RequestBody PetsEntity pet) {
        return service.salvarPet(pet);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public PetsEntity atualizar(
            @PathVariable Long id,
            @RequestBody PetsEntity pet) {

        return service.atualizarPet(id, pet);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluirPet(id);
    }
}