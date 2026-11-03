package com.example.cadastroprodutos.service;

import com.example.cadastroprodutos.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public void removerPorNome(String nome) {
        produtos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }

    public List<Produto> listar(String busca) {
        if (busca == null || busca.isBlank()) {
            return new ArrayList<>(produtos);
        }
        String termo = busca.trim().toLowerCase();
        return produtos.stream()
                .filter(p -> p.getNome().toLowerCase().contains(termo)
                        || p.getCategoria().toLowerCase().contains(termo))
                .toList();
    }
}
