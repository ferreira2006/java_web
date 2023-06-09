# CRUD Java WEB - Spring Boot - Spring MVC – Spring Data JPA – ThymeLeaf - Hibernate - MySQL

- **Spring Boot**: Cria uma estrutura padronizada para o nosso projeto e faz o deploy do nosso aplicativo Web Java.
- **Spring MVC**: Fornece a implementação MVC da nossa aplicação.
- **Spring Data JPA**: Abstrai o desenvolviemnto da camada de acesso a dados, esqueça DAOs e foque nas regras de negócio.
- **ThymeLeaf**: Trabalha na codificação da camada de visualização em substituição ao JSP e JSTL.
- **Hibernate**: Framework ORM que implementação JPA, seu uso é evidenciado nas anotações das Entidades e nas validações.
- **MySQL**: Será nossa base de dados.


---
## Pra quem tem ***PRESSA***:
---
	1 - Faça download do projeto https://github.com/ferreira2006/java_web.git;
	2 - Importe o projeto **/crud** para sua IDE;
	3 - Crie o um banco de dados com o nome **crud**
	4 - Altere o usuario e senha do BD no arquivo de configuração **application.properties**
	5 - Rode a classe CrudApplication.java como **Aplicação Java** ou **Spring Boot App**
	6 - Acesse no navegador o endereço http://localhost:9090
	7 - Se tudo correu bem deve aparecer no navegador uma página semelhante a da figura:
	
[![Imagem da página iniical da aplicação](/../../../../ferreira2006/imagens/blob/master/gitimg/imagens_Crud_Spring_MVC/00_localhost.png)](#)
	
---
## Pra quem quer ir na ***MANHA***:
---
### 1 - Crie uma nova base de dados:
	CREATE SCHEMA `crud`;

### 2 - Para rodar a aplicação que eu disponobilizei altere o usuário e senha (Mysql) no arquivo application.properties
	
	spring.datasource.url=jdbc:mysql://localhost:3306/crud
	spring.datasource.username=USUARIO_BD
	spring.datasource.password=SENHA_BD
---	
### 3 - 1 Crie um aplicativo Spring Boot e selecionar dependências
Acesse https://start.spring.io/ e configure um novo projeto conforme a figura abaixo:

[![Imagem da janela de configuração de um novo projeto no site do spring boot](/../../../../ferreira2006/imagens/blob/master/gitimg/imagens_Crud_Spring_MVC/01_initializr.png)](#)

**Project**: Maven
**Language**: Java
**Spring Boot**: 3.0.6 (*o mais atual sem ser (SNAPSHOT ou M2)*)
**Group**: com.example
**Artifact**: crud
**Name**: crud
**Description**: Demo project for Spring Boot
**Package name**: com.example.crud
**Packaging**: Jar (*SIM nosso app é web mas selecione **JAR**, pois o app rodará em qualquer máquina com **JAVA** instalado e o **Spring Framework** embute um servidor **Tomcat** em cada aplicativo que você desenvolver, o deploy em um **container de servlets** (**Tomcat**, **Jboss**, **Wildfly**) se torna desnecessário*)
**Java**: 17

Adicione as dependências:
	- **Spring Web**
	- **Thymeleaf** 
	- **Spring Data JPA**
	- **MySQL Driver**
	- **Spring Boot DevTools** 
	(*Ctrl+B e pesquise pelo nome das dependências*).
Obs: Aqui é o local onde você indicará também outras dependências quando tiver conhecimento prévio da necessidade da mesma, ex: **JPA**, **Mysql** e outras. Caso uma dependência surja após o projeto já ter sido criado, basta acrescentar a mesma no arquivo **pom.xml** que o Maven cuidará da importação.

Clique em **GENERATE (CTRL+ENTER)**

### 3 - 2 Extraia o projeto do arquivo zipado (**crud.zip**) que foi baixado em seu computador.

[![Imagem do arquivo zip criado no Spring Boot](/../../../../ferreira2006/imagens/blob/master/gitimg/imagens_Crud_Spring_MVC/02_crd.zip.png)](#)

### 4 - 1 Importe o projeto (**crud**) para sua **IDE** favorita (Pode importar como um **project from File System** (Menu File) ou como **Projeto Maven** (Menu Import), o resultado será o mesmo)
Exemplo de importação para o eclipse via *Menu File -> Import Projects from File System…*:

[![Imagem da janela de importação de projetos do eclipse](/../../../../ferreira2006/imagens/blob/master/gitimg/imagens_Crud_Spring_MVC/03_import.png)](#)

### 4 - 2 Para importação via Maven vá em *File -> Import -> Maven -> Existing Maven Project -> Browse (localize o diretório do projeto) -> Finish*.

[![Imagem da janela de importação de projetos Maven no eclipse](/../../../../ferreira2006/imagens/blob/master/gitimg/imagens_Crud_Spring_MVC/04_import_mavenCapturar.png)](#)

### 4 - 3 Localize o projeto descompactado no seu computador (provavelmente pasta de Downloads):

[![Imagem da janela de localização de arquivos no computador](/../../../../ferreira2006/imagens/blob/master/gitimg/imagens_Crud_Spring_MVC/05_localizar_projeto.png)](#)

### 4 - 4 Importe o projeto:

[![Imagem da janela de importação de projetos no eclipse](/../../../../ferreira2006/imagens/blob/master/gitimg/imagens_Crud_Spring_MVC/07_importar_projeto.png)](#)

### 5 - O Maven irá atualizar e construir nossa aplicação, fornecendo esttrutura e dependências.
Após as atualizações e importações do **Maven** a estrutura da sua aplicação estará pronta, você economizou tempo e pode se dedicar a codificar suas regras de negócio. 

[![Imagem da IDE eclipse com a estrutura completa do projeto](/../../../../ferreira2006/imagens/blob/master/gitimg/imagens_Crud_Spring_MVC/08_estrutura_projeto.png)](#)

---
### Replique os arquivos do projeto
### Os códigos interessantes e/ou importantes estão comentados
