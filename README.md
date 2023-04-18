# CEP Frete Service 🚚✉️
O projeto CEP Frete Service é uma aplicação desenvolvida em Java para consulta de endereços através do CEP, bem como cálculo de frete para determinado CEP. Para o projeto foi utilizado Git-flow para versionamento, e inclui testes com JUnit 5 e Cucumber, DockerFile, docker-compose e tratamento de exceções.

# Tecnologias utilizadas 💻
  - Java 11
  - Spring Boot
  - JUnit 5
  - Cucumber
  - Docker & Docker Compose
  - Git-flow
  - Swagger

# Funcionalidades 🚀
Consulta de endereços por CEP
Cálculo de frete para determinado CEP
Tratamento de exceções personalizado
Testes com JUnit e Cucumber
DockerFile e docker-compose para facilitar a implantação

# Como iniciar o projeto 🚀
## Para iniciar o projeto, siga as etapas abaixo:

### Pré-requisitos 📚
Instale o Java 11 ou superior
Instale o Maven (opcional, se desejar usar a linha de comando)
Instale o Docker e Docker Compose (se desejar usar o Docker para implantar a aplicação)
Executando a aplicação localmente 🖥️
Clone o repositório para sua máquina local:

``` bash
git clone https://github.com/seu_usuario/cep-frete-service.git
```
### Navegue até a pasta do projeto:

``` bash
Copy code
cd cep-frete-service
```
Execute a aplicação usando Maven:

``` bash
mvn spring-boot:run
```
### Ou, se preferir, importe o projeto para a sua IDE favorita e execute a classe CepEFreteServiceApplication.

### A aplicação estará disponível em http://localhost:8080.

## Executando a aplicação com Docker 🐳
Clone o repositório para sua máquina local:

``` bash
git clone https://github.com/seu_usuario/cep-frete-service.git
```
### Navegue até a pasta do projeto:

``` bash
cd cep-frete-service
```
## Construa a imagem Docker:

``` bash
docker build -t cep-frete-service .
```
## Execute a aplicação usando Docker:

``` bash
docker run -p 8080:8080 cep-frete-service
```

## Ou, se preferir, utilize o docker-compose:

``` bash
docker-compose up
```
### A aplicação estará disponível em http://localhost:8080.

## Documentação da API com Swagger 📚
O projeto inclui a documentação da API utilizando o Swagger, uma ferramenta de documentação e visualização interativa de APIs RESTful. Para acessar a interface do Swagger e explorar as rotas disponíveis na aplicação, vá para o seguinte endereço no navegador:

``` bash
http://localhost:8080/swagger-ui/
```

## Ao acessar o Swagger UI, você poderá ver o endpoint de consulta endereço disponível na API e interagir com ele, enviando requisições e visualizando as respostas diretamente na interface web.

## Executando os testes 🧪
Para executar os testes JUnit e Cucumber, use o seguinte comando:

``` bash
mvn test
```
#### Os resultados dos testes serão exibidos na saída do terminal.
