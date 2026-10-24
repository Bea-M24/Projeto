package com.senai.projeto.service;

import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.entity.PetsEntity;
import com.senai.projeto.repository.ClienteRepository;
import com.senai.projeto.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsService {

    @Autowired
    private PetsRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    // LISTAR TODOS OS PETS
    public List<PetsEntity> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR PET POR ID
    public PetsEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet não encontrado."));
    }

    // SALVAR UM PET
    public PetsEntity salvarPet(PetsEntity pet) {

        Long clienteId = pet.getCliente().getId();

        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        pet.setCliente(cliente);

        return repository.save(pet);
    }

    // ATUALIZAR UM PET
    public PetsEntity atualizarPet(Long id, PetsEntity pet) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Pet não encontrado.");
        }

        Long clienteId = pet.getCliente().getId();

        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        pet.setId(id);
        pet.setCliente(cliente);

        return repository.save(pet);
    }

    // EXCLUIR UM PET
    public void excluirPet(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Pet não encontrado.");
        }

        repository.deleteById(id);
    }
}
