package br.com.concessionaria.gestao_veiculos.repository;

import br.com.concessionaria.gestao_veiculos.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Este é o VeiculoRepository
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}