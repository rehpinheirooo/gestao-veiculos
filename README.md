# Sistema de Gestão de Estoque Automotivo 🚗

Este projeto é uma aplicação backend robusta desenvolvida para o gerenciamento eficiente de um inventário de veículos e marcas. A solução foca na organização de dados, integridade referencial e facilidade de operação de um estoque automotivo profissional.

## 🚀 Tecnologias Utilizadas

* *Java 17*: Linguagem principal utilizada para garantir performance e tipagem forte.
* *Spring Boot*: Framework utilizado para estruturar a aplicação e agilizar o desenvolvimento.
* *Spring Data JPA*: Abstração da camada de dados para facilitar a persistência e consultas.
* *MySQL*: Banco de dados relacional utilizado para armazenamento persistente das informações.
* *Maven*: Gerenciador de dependências e automação de build.

## 📂 Estrutura e Arquitetura

O projeto foi construído seguindo padrões de *Clean Code* e separação de responsabilidades em camadas:

* *entity*: Classes que representam as tabelas Veiculo e Marca no banco de dados.
* *repository*: Interfaces que estendem o JpaRepository, responsáveis pela comunicação direta com o banco.
* *service*: Camada onde reside toda a lógica de negócio e validações do sistema.

## 🛠️ Como Executar o Projeto

1.  *Clone o repositório:*
    bash
    git clone [https://github.com/rehpinheirooo/gestao-veiculos.git](https://github.com/rehpinheirooo/gestao-veiculos.git)
    

2.  *Configuração do Banco de Dados:*
    * Certifique-se de ter o MySQL instalado e rodando.
    * Crie o schema: CREATE DATABASE gestao_veiculos;.
    * Configure suas credenciais (usuário e senha) no arquivo src/main/resources/application.properties.

3.  *Execução via IDE:*
    * Abra o projeto no VS Code ou IntelliJ.
    * Execute a classe GestaoVeiculosApplication.java.

## 📈 Funcionalidades Implementadas

* *CRUD de Marcas*: Cadastro, listagem, atualização e exclusão.
* *Gerenciamento de Veículos*: Controle total de estoque vinculado às marcas cadastradas.
* *Validação de Dados*: Verificação de existência de registros (IDs) antes de operações críticas de escrita ou deleção.
* *Filtros Otimizados*: Consultas customizadas para busca eficiente no inventário.

---
Desenvolvido por *Renato Pinheiro* como parte do portfólio acadêmico em Análise e Desenvolvimento de Sistemas.
