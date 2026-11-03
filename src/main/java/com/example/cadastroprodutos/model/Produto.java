package com.example.cadastroprodutos.model;
public class Produto {
    private String nome; // nome do produto
    private double preco; // preço em reais
    private String categoria; // ex: Eletrônico, Vestuário
    private int estoque;
    // Construtor vazio — obrigatório para o Thymeleaf funcionar
    public Produto() {
    }
    // Getters e Setters — permitem ler e alterar os atributos
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public int getEstoque() { return this.estoque; }
    public void setEstoque(int estoque) { this.estoque = estoque; }
}