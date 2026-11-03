package com.example.cadastroprodutos.service;

import com.example.cadastroprodutos.model.Produto;
import com.example.cadastroprodutos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void adicionar(Produto produto) {
        repository.save(produto);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

    public List<Produto> listar(String busca) {
        if (busca == null || busca.isBlank()) {
            return repository.findAll();
        }
        String termo = busca.trim();
        return repository.findByNomeContainingIgnoreCaseOrCategoriaContainingIgnoreCase(termo, termo);
    }
}