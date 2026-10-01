# Sistema Delivery API

API REST para gerenciamento de um sistema de delivery, desenvolvida como projeto de estudo e portfólio.

## Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Docker / Docker Compose
- REST API

## Funcionalidades
- Cadastro de clientes
- Cadastro de restaurantes
- Cadastro de produtos
- Categorias de produtos
- Criação e acompanhamento de pedidos
- Itens de pedido
- Controle de status do pedido
- Cálculo automático do total
- Persistência em PostgreSQL

## Endpoints principais

### Clientes
- GET /api/clients
- POST /api/clients

### Restaurantes
- GET /api/restaurants
- POST /api/restaurants

### Produtos
- GET /api/products
- POST /api/products

### Pedidos
- GET /api/orders
- POST /api/orders
- PATCH /api/orders/{id}/status

## Como executar

Com Docker:
```bash
docker compose up --build
```

A API ficará disponível em `http://localhost:8080`.

## Objetivo

Projeto educacional de portfólio para praticar desenvolvimento backend, APIs REST, modelagem relacional, Spring Boot, JPA e PostgreSQL.

**Autor:** Luis Fillipe Backer Faria  
**GitHub:** https://github.com/lfillipebf-ai
