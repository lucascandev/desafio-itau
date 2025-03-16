# Desafio de Programação Itaú Unibanco - API de Transações

Este repositório contém a solução para o desafio de programação proposto pelo Itaú Unibanco, que consiste na criação de uma API REST para o processamento de transações financeiras e cálculo de estatísticas.

## Descrição

A API desenvolvida permite o registro de transações, a exclusão de todas as transações e o cálculo de estatísticas das transações ocorridas nos últimos 60 segundos.

## Funcionalidades

-   **Registro de Transações (POST /transacao):** Permite o registro de transações com valor e data/hora.
-   **Exclusão de Transações (DELETE /transacao):** Permite a exclusão de todas as transações registradas.
-   **Cálculo de Estatísticas (GET /estatistica):** Retorna estatísticas das transações dos últimos 60 segundos, incluindo contagem, soma, média, mínimo e máximo.

## Tecnologias Utilizadas

-   Java 17
-   Spring Boot 3.1.5
-   Maven

## Pré-requisitos

-   Java 17 ou superior
-   Maven 3.6 ou superior
-   Git

## Como Executar

1.  Clone o repositório:

    ```bash
    git clone [https://github.com/lucascandev/desafio-itau.git](https://github.com/lucascandev/desafio-itau.git)
    ```

2.  Navegue até o diretório do projeto:

    ```bash
    cd desafio-itau
    ```

3.  Execute a aplicação Spring Boot:

    ```bash
    mvn spring-boot:run
    ```

4.  A API estará disponível em `http://localhost:8080`.

## Endpoints

-   **POST /transacao**
    -   Descrição: Registra uma nova transação.
    -   Corpo da requisição:

        ```json
        {
            "valor": 123.45,
            "dataHora": "2023-10-27T12:34:56.789Z"
        }
        ```

    -   Respostas:
        -   201 Created: Transação criada com sucesso.
        -   422 Unprocessable Entity: Transação inválida.
        -   400 Bad Request: Requisição inválida.
-   **DELETE /transacao**
    -   Descrição: Exclui todas as transações.
    -   Respostas:
        -   200 OK: Transações excluídas com sucesso.
-   **GET /estatistica**
    -   Descrição: Retorna as estatísticas das transações dos últimos 60 segundos.
    -   Respostas:
        -   200 OK: Retorna um JSON com as estatísticas.

## Testes

Para executar os testes unitários, utilize o seguinte comando:

```bash
mvn test
```

## Considerações

-   As transações são armazenadas em memória, ou seja, ao reiniciar a aplicação, os dados são perdidos.
-   A API segue as restrições técnicas do desafio, como não utilizar banco de dados ou cache externo.
-   A data e hora das transações devem estar no formato ISO 8601 UTC.

## Autor

Lucas Candido Luiz ~~ lucascandev

## Licença

Este projeto está sob a licença MIT.