# desafio-contatos

# Foi criado um projeto com estrura do maven, e configurado para o uso do spring-data, spring-mvc e spring boot.
# Foi criada também a estrutura inicial para execução de testes de unidade com Junit.
# Os arquivos de propriedades assim como os dados de conexão de banco estão dentro de um .properties nas pastas do projeto.
  Em um projeto maior, seria configurado isso para uma pasta fora do servidor de aplicação e dentro de um "standalone.xml" da vida de um jboss por exemplo.
# O script de criação do BD está na raiz do projeto, foi usado o Postgres 9.6.
# O arquivo AppConfig.java pode ser executado para "subir" o contexto na maquina do desenvolvedor.


#Infelizmente não deu tempo implementar nem 50% de tudo que queria, além dos métodos de Repository, service e Controller das entidades que ficaram faltando,
ainda tinha essas coisas que desejava fazer:

## Criar testes separados para as camadas "service" e "repository", usaria Mockito para Mockar as chamadas do services ao repository,
assim serando as responsabilidades dos testes entre negócio e integração do o BD.
## Usar o coverage para saber a cobertura de testes automaticos da minha aplicação.
## Usar auditorias nas tabelas com JPA Auditing.
## Documentar com JAVA doc
## Tratamento correto das Exeções e criação de uma CustomException para o sistema, para validaçoes de negócio com mensagens configuradas.
## Configuração de builds no maven.

Dentre várias outras coisas.

#Peço desculpas por não ter terminado a tempo, e fico a disposição para esclarecer qualquer dúvida.
