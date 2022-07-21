<h1 align="center">
    Hiring Coins API
</h1>

## 💻 Sobre o projeto

API para cadastro e controle do pontos/moedas (Hiring Coins) da loja Hiring Coders Store.

## 🛠 Tecnologias/Ferramentas

As seguintes tecnologias/ferramentas foram usadas na construção do projeto:

- Java
- Spring Boot
- Jakarta Persistence API (JPA)
- Spring Data JPA
- Flyway
- MySQL
- Lombok

## 🚀 O que esta API realiza?

A API realiza cadastro/atualização de Clientes, e permite o cadastro de Transações (Crédito ou Débito) que incrementam ou decrementam o saldo de pontos (Hiring Coins do Cliente)

## 🌍 Endpoints

### 1. GET /v1/clients
Endpoint para listagem paginada dos Clientes cadastrados

### 2. PUT /v1/clients
Endpoint para salvar ou atualizar um Cliente

### 3. GET /v1/clients/{clientUuid}
Endpoint para obter um cadastro de Cliente através do UUID com todos os detalhes

### 4. GET /v1/clients/{clientUuid}/transactions
Endpoint para listagem paginada das Transações de um Cliente

### 5. POST /v1/transactions
Endpoint para salvar uma nova transação (Crédito ou Débito)

### 6. GET /v1/transactions/{transactionUuid}
Endpoint para obter uma Transação através do UUID com todos os detalhes

## 📋 Documentação

### Para consultar a documentação usando OpenAPI, acesse [aqui](https://hccontroll03.app.br/swagger-ui/index.html)

## 🦸 Autor

Desenvolvido por Douglas Rodrigues 👋🏽 [Entre em contato!](https://www.linkedin.com/in/douglas-rodrigues-pnz/)


