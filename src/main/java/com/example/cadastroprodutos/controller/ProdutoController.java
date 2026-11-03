package com.example.cadastroprodutos.controller;

import com.example.cadastroprodutos.model.Produto;
import com.example.cadastroprodutos.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/cadastrar";
    }

    @GetMapping("/cadastrar")
    public String exibirFormulario(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto(@ModelAttribute Produto produto, RedirectAttributes redirectAttributes) {
        if (produto.getPreco() <= 0) {
            redirectAttributes.addFlashAttribute("erroPreco", "O produto precisa ter um preço maior que 0.");
            return "redirect:/cadastrar";
        }

        produtoService.adicionar(produto);
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String exibirLista(@RequestParam(value = "busca", required = false) String busca, Model model) {
        model.addAttribute("produtos", produtoService.listar(busca));
        model.addAttribute("busca", busca);
        return "lista";
    }

    @PostMapping("/remover")
    public String removerItem(@RequestParam("nome") String nome) {
        produtoService.removerPorNome(nome);
        return "redirect:/lista";
    }
}
