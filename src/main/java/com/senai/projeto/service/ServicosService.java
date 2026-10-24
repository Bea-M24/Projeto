package com.senai.projeto.service;

import com.senai.projeto.entity.ServicosEntity;
import com.senai.projeto.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicosService {

    @Autowired
    private ServicosRepository repository;

    // LISTAR TODOS OS SERVIÇOS
    public List<ServicosEntity> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR SERVIÇO POR ID
    public ServicosEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado."));
    }

    // SALVAR UM SERVIÇO
    public ServicosEntity salvarServico(ServicosEntity servico) {
        return repository.save(servico);
    }

    // ATUALIZAR UM SERVIÇO
    public ServicosEntity atualizarServico(Long id, ServicosEntity servico) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Serviço não encontrado.");
        }

        servico.setId(id);
        return repository.save(servico);
    }

    // EXCLUIR UM SERVIÇO
    public void excluirServico(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Serviço não encontrado.");
        }

        repository.deleteById(id);
    }
}