package com.senai.projeto.service;

import com.senai.projeto.entity.ProdutosEntity;
import com.senai.projeto.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository repository;

    // LISTAR TODOS OS PRODUTOS
    public List<ProdutosEntity> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR PRODUTO POR ID
    public ProdutosEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));
    }

    // SALVAR UM PRODUTO
    public ProdutosEntity salvarProduto(ProdutosEntity produto) {
        return repository.save(produto);
    }

    // ATUALIZAR UM PRODUTO
    public ProdutosEntity atualizarProduto(Long id, ProdutosEntity produto) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        produto.setId(id);
        return repository.save(produto);
    }

    // EXCLUIR UM PRODUTO
    public void excluirProduto(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        repository.deleteById(id);
    }
}
