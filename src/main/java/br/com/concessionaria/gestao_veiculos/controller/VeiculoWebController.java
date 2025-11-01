package br.com.concessionaria.gestao_veiculos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/veiculos") 
public class VeiculoWebController {

    // 1. Exibe a lista de veículos (READ)
    @GetMapping
    public String exibirListaVeiculos() {
        return "lista-veiculos"; 
    }

    // 2. Exibe o formulário de cadastro (CREATE)
    @GetMapping("/cadastrar") 
    public String exibirFormularioCadastro() {
        return "cadastro-veiculo"; 
    }

    // 3. Exibe o formulário de edição (UPDATE)
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id) {
        // O ID é passado para o JavaScript no HTML via URL
        return "cadastro-veiculo"; 
    }
}