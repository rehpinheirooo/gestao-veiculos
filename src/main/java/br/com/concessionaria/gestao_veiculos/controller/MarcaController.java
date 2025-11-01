package br.com.concessionaria.gestao_veiculos.controller;

import br.com.concessionaria.gestao_veiculos.entity.Marca;
import br.com.concessionaria.gestao_veiculos.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/api/marcas") 
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    // Rota GET para listar
    @GetMapping
    public List<Marca> listarTodas() {
        return marcaService.findAll();
    }

    // Rota POST para criar
    @PostMapping
    public Marca criarMarca(@RequestBody Marca marca) {
        return marcaService.save(marca);
    }
    
    // Rota PUT para atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Marca> atualizarMarca(@PathVariable Long id, @RequestBody Marca marcaDetalhes) {
        return marcaService.findById(id)
            .map(marcaExistente -> {
                marcaExistente.setNome(marcaDetalhes.getNome());
                Marca marcaAtualizada = marcaService.save(marcaExistente);
                return ResponseEntity.ok(marcaAtualizada);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // Rota DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMarca(@PathVariable Long id) {
        if (marcaService.findById(id).isPresent()) {
            marcaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}