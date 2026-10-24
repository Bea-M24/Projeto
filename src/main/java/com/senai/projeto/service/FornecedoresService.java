package com.senai.projeto.service;

import com.senai.projeto.entity.FornecedoresEntity;
import com.senai.projeto.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedoresService {

    @Autowired
    private FornecedoresRepository repository;

    // LISTAR TODOS OS FORNECEDORES
    public List<FornecedoresEntity> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR FORNECEDOR POR ID
    public FornecedoresEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fornecedor não encontrado."));
    }

    // SALVAR UM FORNECEDOR
    public FornecedoresEntity salvarFornecedor(FornecedoresEntity fornecedor) {
        return repository.save(fornecedor);
    }

    // ATUALIZAR UM FORNECEDOR
    public FornecedoresEntity atualizarFornecedor(Long id, FornecedoresEntity fornecedor) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Fornecedor não encontrado.");
        }

        fornecedor.setId(id);
        return repository.save(fornecedor);
    }

    // EXCLUIR UM FORNECEDOR
    public void excluirFornecedor(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Fornecedor não encontrado.");
        }

        repository.deleteById(id);
    }
}