# CRUD Java WEB - Spring Boot - Spring MVC – Spring Data JPA – ThymeLeaf - Hibernate - MySQL

- **Spring Boot**: Cria uma estrutura padronizada para o nosso projeto e faz o deploy do nosso aplicativo Web Java.
- **Spring MVC**: Fornece a implementação MVC da nossa aplicação.
- **Spring Data JPA**: Abstrai o desenvolviemnto da camada de acesso a dados, esqueça DAOs e foque nas regras de negócio.
- **ThymeLeaf**: Trabalha na codificação da camada de visualização em substituição ao JSP e JSTL.
- **Hibernate**: Framework ORM que implementação JPA, seu uso é evidenciado nas anotações das Entidades e nas validações.
- **MySQL**: Será nossa base de dados.


### 1 - Crie uma nova base de dados:
	CREATE SCHEMA `crud`;

### 2 - Altere o usuário e senha (Mysql) no arquivo application.properties
	
	spring.datasource.url=jdbc:mysql://localhost:3306/crud
	spring.datasource.username=USUARIO_BD
	spring.datasource.password=SENHA_BD
	
### 3 - 