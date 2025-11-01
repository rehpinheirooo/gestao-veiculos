package br.com.concessionaria.gestao_veiculos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType; 
import java.math.BigDecimal; // Import para o campo 'preco'

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    // NOVOS ATRIBUTOS ADICIONADOS:
    private String modelo; // <-- NOVO
    private String cor;
    private Integer ano;
    private BigDecimal preco; // <-- NOVO (usar BigDecimal para dinheiro)
    private Integer quilometragem; // <-- NOVO
    private String status; // <-- NOVO (ex: "Em Estoque", "Vendido")
    // FIM DOS NOVOS ATRIBUTOS

    // Relacionamento com Marca
    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name = "marca_id")
    private Marca marca; 
    
    // --- Getters e Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // GETTER e SETTER para MODELO (NOVO)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
    
    // GETTER e SETTER para PRECO (NOVO)
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    // GETTER e SETTER para QUILOMETRAGEM (NOVO)
    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    // GETTER e SETTER para STATUS (NOVO)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}