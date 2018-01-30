# Desafio Contatos
Este projeto tem como objetivo desenvolver uma aplicação Spring que implementa um CRUD de contatos para um sistema de gerenciamento de despesas.

## Ferramentas Utilizadas
* MySQL 5.7
* JDK 1.8
* Maven 4.0
* Bootstrap 4
* Spring Framework 1.5.9
* Thymeleaf Template Engine

## Features
* Criar um contato.
* Deletar um contato.
* Atualizar dados do contato.
* Pesquisar contato por nome, endereço ou telefone.
* Visualizar contatos.
* Persistência dos dados no banco.
* O arquivo 'data.sql' popula inicialmente o banco de dados com alguns contatos.

## Requisitos
1. Na linha de comando (Linux), abra o MySQL(password:root):
```mysql -u root -p```
2. Crie o banco de dados:
```create database desafio_contatos;```

## Instalação/Execução (Linux):
1. Primeiramente, clone este projeto.
```git clone https://github.com/cassioesp/desafio-contatos.git```
2. Vá até a pasta raiz do projeto e execute:
```mvn spring-boot:run```
3. Acesse http://localhost:8080/.

## Screenshots
Tela Principal
<img src="https://imgur.com/E4FzAvo.jpg"></img>
Tela Adicionar Contato
<img src="https://imgur.com/xpGJmj4.jpg"></img>
Tela Pesquisar Contato
<img src="https://imgur.com/QHcyqpx.jpg"></img>




# desafio-contatos

### Desafio Conductor de Seleção 
Olá, queremos convidá-lo a participar de nosso desafio de seleção.  Pronto para participar? Seu trabalho será visto por nosso time e você receberá ao final um feedback sobre o que achamos do seu trabalho. Não é legal?

### Sobre a oportunidade 
A vaga é para Desenvolvedor Java, temos vagas com diversos níveis de senioridade e para cada um deles utilizaremos critérios específicos considerando esse aspecto, combinado? 
Se você for aprovado nesta etapa, será convidado para uma entrevista final com nosso time técnico.

### Desafio Técnico
  Desenvolver um sistema de gerenciamento de despesas, para manter controle entre gastos e receita:
  - Pré-requisitos:
    ```
    * Utilização do SGBD Oracle ou MySQL.
    * JDK 1.8+
    * Maven 3+
    * JUnit 4+
    * Framework Web a critério (Servlets, JSF, Spring MVC ou afins)
    * Criação de um DUMP com massa de dados.
    ```

  - O que esperamos como escopo:
    ```
    * Adicionar e Manter contato;
    * Adicionar/Alterar/Remover: dados do contato;
    * Consultar Contatos, por filtros de dados;
    * API Rest para cadastro de telefone ao contato;
    * Possibilidade de categorizar e manter contatos em Grupos (Escopo Bônus);
    ```
    
  - O que vamos avaliar:
    ```
    * Seu código; 
    * Organização;
    * Boas práticas;
    ```

### Instruções
      1. Faça o fork do desafio e crie uma branch 'desafio_contatos_nome_candidato';
      2. Desenvolva. Você terá 2 (dois) dias a partir da data do envio do desafio; 
      3. Após concluir seu trabalho faça um push; 
      4. Crie um arquivo de texto com a nomenclatura README.MD com a explicação de como devemos executar o 
        projeto e com uma descrição do que foi feito; 
      5. Solicite o Merge request para o repositório original e que a força esteja com você.
