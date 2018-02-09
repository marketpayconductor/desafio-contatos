
# Desafio Contatos
Este projeto tem como objetivo desenvolver uma aplicação Spring que implementa um CRUD de contatos para um sistema de gerenciamento de despesas.

## Ferramentas Utilizadas
* MySQL 5
* JDK 1.8
* Maven 3.5
* Angular 5
* Angular Material
* Spring Framework 1.5
* Flywaydb

## Features
* Adicionar um contato.
* Remover um contato.
* Atualizar dados do contato.
* Pesquisar contato por nome.
* Pesquisar por categoria
* Visualizar contatos.
* Persistência dos dados.
* Migration com dados para popular a base

## Execução
1. Clone o projeto ```git clone https://github.com/andersonleal/desafio-contatos```
## Server
1. Configurar o flywaydb no pom.xml com as credenciais do banco, um usuário que tenha permissão de criar esquemas no myqsl
2. Configurar o arquivo resources/application.yml com usuário e senha do mysql
3. Entrar na pasta server e executar 
```mvn flyway:migrate```
```mvn spring-boot:run```
## Client
1. Ter instalado o NodeJs [https://nodejs.org/en/download/](https://nodejs.org/en/download/)
2. Entrar na pasta client e executar
```npm install```
```npm start```
3. Acesse [http://localhost:4200](http://localhost:4200)

## Execução (Docker):
1. No terminal execute
```docker-compose build```
```docker-compose start mysql```
```docker-compose up```
2. Acesse [http://localhost](http://localhost)

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