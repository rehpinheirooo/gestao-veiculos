package br.com.concessionaria.gestao_veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.concessionaria.gestao_veiculos.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    // A interface JpaRepository já nos dá os métodos de salvar, buscar, deletar, etc.
}