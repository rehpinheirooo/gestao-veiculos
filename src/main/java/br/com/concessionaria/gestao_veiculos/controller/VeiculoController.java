package br.com.concessionaria.gestao_veiculos.controller;

import br.com.concessionaria.gestao_veiculos.entity.Veiculo;
import br.com.concessionaria.gestao_veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    // Rota GET: Listar todos os veículos
    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarTodos();
    }

    // Rota GET: Buscar veículo por ID (necessário para o modo Edição no frontend)
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.buscarPorId(id);
        return veiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Rota POST: Cadastrar novo veículo
    @PostMapping
    public Veiculo cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.salvar(veiculo);
    }
    
    // 💡 CORREÇÃO AQUI: Rota PUT para atualizar um veículo existente
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculoDetalhes) {
        try {
            Veiculo veiculoAtualizado = veiculoService.atualizar(id, veiculoDetalhes);
            return ResponseEntity.ok(veiculoAtualizado);
        } catch (RuntimeException e) {
            // Caso o veículo com o ID especificado não seja encontrado
            return ResponseEntity.notFound().build();
        }
    }

    // Rota DELETE: Excluir veículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        if (veiculoService.buscarPorId(id).isPresent()) {
            veiculoService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}