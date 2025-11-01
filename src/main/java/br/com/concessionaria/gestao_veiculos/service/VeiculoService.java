package br.com.concessionaria.gestao_veiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.concessionaria.gestao_veiculos.entity.Veiculo;
import br.com.concessionaria.gestao_veiculos.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
    
    // 💡 CORREÇÃO AQUI: Lógica para atualizar um veículo
    public Veiculo atualizar(Long id, Veiculo veiculoDetalhes) {
        return veiculoRepository.findById(id).map(veiculoExistente -> {
            
            // Aplica as atualizações de forma segura
            veiculoExistente.setNome(veiculoDetalhes.getNome());
            veiculoExistente.setModelo(veiculoDetalhes.getModelo());
            veiculoExistente.setCor(veiculoDetalhes.getCor());
            veiculoExistente.setAno(veiculoDetalhes.getAno());
            veiculoExistente.setPreco(veiculoDetalhes.getPreco());
            veiculoExistente.setQuilometragem(veiculoDetalhes.getQuilometragem());
            veiculoExistente.setStatus(veiculoDetalhes.getStatus());
            
            // Atualiza o relacionamento de Marca
            if (veiculoDetalhes.getMarca() != null) {
                veiculoExistente.setMarca(veiculoDetalhes.getMarca());
            }

            // Salva a entidade atualizada de volta no banco
            return veiculoRepository.save(veiculoExistente);
        }).orElseThrow(() -> new RuntimeException("Veículo não encontrado com ID: " + id));
    }

    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }
}