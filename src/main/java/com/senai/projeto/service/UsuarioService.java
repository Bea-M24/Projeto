package com.senai.projeto.service;

import com.senai.projeto.entity.UsuarioEntity;
import com.senai.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // LISTAR TODOS OS USUÁRIOS
    public List<UsuarioEntity> listarTodos() {
        return repository.findAll();
    }

    // SALVAR UM USUÁRIO
    public UsuarioEntity salvarUsuario(UsuarioEntity usuario) {
        return repository.save(usuario);
    }

    // ATUALIZAR UM USUÁRIO
    public UsuarioEntity atualizarUsuario(Long id, UsuarioEntity usuario) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }

        usuario.setId(id);
        return repository.save(usuario);
    }

    // EXCLUIR UM USUÁRIO
    public void excluirUsuario(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }

        repository.deleteById(id);
    }
}
