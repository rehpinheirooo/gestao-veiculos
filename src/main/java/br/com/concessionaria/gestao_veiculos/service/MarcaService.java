package br.com.concessionaria.gestao_veiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.concessionaria.gestao_veiculos.entity.Marca;
import br.com.concessionaria.gestao_veiculos.repository.MarcaRepository;

import java.util.List;
import java.util.Optional;

@Service 
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> findById(Long id) {
        return marcaRepository.findById(id);
    }

    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    public void deleteById(Long id) {
        marcaRepository.deleteById(id);
    }
}