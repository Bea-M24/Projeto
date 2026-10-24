package com.senai.projeto.service;

import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    // LISTAR TODOS OS CLIENTES
    public List<ClienteEntity> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR CLIENTE POR ID
    public ClienteEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
    }

    // INSERT - POST - SALVAR UM CLIENTE
    public ClienteEntity salvarCliente(ClienteEntity cliente) {

        // VERIFICA SE O E-MAIL DO CLIENTE JÁ ESTÁ NO BANCO DE DADOS
        if (repository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }

        return repository.save(cliente);
    }

    // UPDATE - PUT - ATUALIZAR DADOS
    public ClienteEntity atualizarCliente(Long id, ClienteEntity cliente) {

        // VERIFICA SE O CLIENTE EXISTE
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        // MANTÉM O MESMO ID PARA ATUALIZAR EM VEZ DE CRIAR OUTRO
        cliente.setId(id);

        return repository.save(cliente);
    }

    // DELETE - EXCLUIR CLIENTE
    public void excluirCliente(Long id) {

        // VERIFICA SE O CLIENTE EXISTE
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        repository.deleteById(id);
    }
}
