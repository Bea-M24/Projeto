package com.senai.projeto.controller;

import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // LISTAR TODOS OS CLIENTES
    @GetMapping
    public List<ClienteEntity> listar() {
        return service.listarTodos();
    }

    // BUSCAR CLIENTE POR ID
    @GetMapping("/{id}")
    public ClienteEntity buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // CADASTRAR CLIENTE
    @PostMapping
    public ResponseEntity<Map<?, ?>> salvar(@RequestBody ClienteEntity cliente) {

        service.salvarCliente(cliente);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cliente cadastrado com sucesso."));
    }

    // ATUALIZAR CLIENTE
    @PutMapping("/{id}")
    public ResponseEntity<Map<?, ?>> atualizar(
            @PathVariable Long id,
            @RequestBody ClienteEntity cliente) {

        service.atualizarCliente(id, cliente);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente atualizado com sucesso."));
    }

    // EXCLUIR CLIENTE
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?, ?>> excluir(@PathVariable Long id) {

        service.excluirCliente(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente excluído com sucesso."));
    }
}
