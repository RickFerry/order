```markdown
# Order Service

## Descrição
Este é um projeto de microserviço para gerenciamento de pedidos, desenvolvido com Spring Boot. Ele utiliza MongoDB como banco de dados, RabbitMQ para mensageria, Lombok para redução de boilerplate code e Swagger para documentação da API.

## Tecnologias Utilizadas
- **Java 17**: Linguagem de programação.
- **Spring Boot**: Framework para facilitar a configuração e publicação de aplicações baseadas em Spring.
- **MongoDB**: Banco de dados NoSQL orientado a documentos.
- **RabbitMQ**: Sistema de mensageria para comunicação entre serviços.
- **Lombok**: Biblioteca Java que utiliza anotações para gerar código boilerplate.
- **Swagger (Springdoc OpenAPI)**: Ferramenta para documentação de APIs REST.

## Configuração e Execução

### Pré-requisitos
- JDK 17
- Maven
- MongoDB rodando localmente ou em um container
- RabbitMQ rodando localmente ou em um container

### Passos para Execução
1. Clone o repositório do projeto.
2. Navegue até a pasta do projeto e execute o comando abaixo para compilar o projeto e baixar as dependências:
   ```
   mvn clean install
   ```
3. Para iniciar a aplicação, execute:
   ```
   mvn spring-boot:run
   ```
4. A aplicação estará disponível em `http://localhost:8080`.

## Documentação da API

![Screenshot 2024-07-16 162520](https://github.com/user-attachments/assets/c831241c-b9d3-4c86-8f45-0a2a5708933b)


Após iniciar a aplicação, a documentação da API estará disponível em `http://localhost:8080/swagger-ui.html`. Aqui, você pode visualizar todos os endpoints disponíveis e testá-los diretamente pela interface do Swagger.

## Contribuindo
Sinta-se à vontade para contribuir com o projeto. Para isso, por favor, siga o processo padrão de fork, criação de branch, commits, e pull request.

## Licença
Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
```
