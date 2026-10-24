package com.senai.projeto.service;

import com.senai.projeto.entity.FuncionariosEntity;
import com.senai.projeto.repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosService {

    @Autowired
    private FuncionariosRepository repository;

    // LISTAR TODOS OS FUNCIONÁRIOS
    public List<FuncionariosEntity> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR FUNCIONÁRIO POR ID
    public FuncionariosEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado."));
    }

    // SALVAR UM FUNCIONÁRIO
    public FuncionariosEntity salvarFuncionario(FuncionariosEntity funcionario) {
        return repository.save(funcionario);
    }

    // ATUALIZAR UM FUNCIONÁRIO
    public FuncionariosEntity atualizarFuncionario(Long id, FuncionariosEntity funcionario) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado.");
        }

        funcionario.setId(id);
        return repository.save(funcionario);
    }

    // EXCLUIR UM FUNCIONÁRIO
    public void excluirFuncionario(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado.");
        }

        repository.deleteById(id);
    }
}
