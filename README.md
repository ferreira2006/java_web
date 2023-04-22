# java_web
java_web_spring_thymeleaf

Java para Web com Spring Framework e Thymeleaf - Hello Word!

Criação de um aplicativo WEB JAVA usando Thymeleaf e Spring Boot.

Domínio do problema:
Criar uma aplicação web usando JAVA (Spring Framework e Thymeleaf) que apresenta uma página inicial estática (HTML) que contenha um link que deve executar uma solicitação HTTP GET ao servidor e obtenha como resposta outra página (HTML) com uma a saudação processada no servidor.

Spring Boot é uma extensão do Spring Framework desenvolvida para a plataforma Java baseado nos padrões de projetos, inversão de controle e injeção de dependência, que visa providenciar vários recursos pré configurados facilitando e acelerando o processo de manutenção e setup para o desenvolvedor.

Desenvolveremos a aplicação em 5 passos:
Criar um aplicativo Spring Boot e selecionar dependências
Criar um Controller Spring MVC 
Fazer a configuração do ViewResolver do Thymeleaf
Criar um Thymeleaf Template - saudacao.html e index.html 
Rodar nossa aplicação web no Tomcat embutido do Spring Framework
1 Criar um aplicativo Spring Boot e selecionar dependências
Acesse https://start.spring.io/ e configure um novo projeto conforme a figura abaixo:

#Imagem do https://start.spring.io/

Project: Maven
Language: Java
Spring Boot: 3.0.6 (o mais atual sem ser (SNAPSHOT ou M2))
Group: com.example
Artifact: helloWorld
Name: helloWorld
Description: Demo project for Spring Boot
Package name: com.example.helloWorld
Packaging: Jar (SIM nosso app é web mas selecione JAR, pois o app rodará em qualquer máquina com JAVA instalado e o Spring Framework embute um servidor Tomcat em cada aplicativo que você desenvolver, o deploy em um container de servlets (Tomcat, Jboss, Wildfly) se torna desnecessário)
Java: 17

Adicione a dependência Spring Web e Thymeleaf (Ctrl+B pesquise por "web" e depois por “thymeleaf”).
Obs: Aqui é o local onde você indicará também outras dependências quando tiver conhecimento prévio da necessidade da mesma, ex: JPA, Mysql e outras. Caso uma dependência surja após o projeto já ter sido criado, basta acrescentar a mesma no arquivo pom.xml que o Maven cuidará da importação.

Clique em GENERATE (CTRL+ENTER)

Extraia o projeto do arquivo zipado (helloWorld.zip) que foi baixado em seu computador.

Importe o projeto (helloWorld) para sua IDE favorita (Pode importar como um project from File System (Menu File) ou como Projeto Maven (Menu Import), o resultado será o mesmo)
Exemplo de importação para o eclipse via Menu File -> Import Projects from File System…:


Para importação via Maven vá em File -> Import -> Maven -> Existing Maven Project -> Browse (localize o diretório do projeto) -> Finish.

# imagem do local de importaçao no eclipse

Após as atualizações e importações do Maven a estrutura da sua aplicação estará pronta, você economizou tempo e pode se dedicar a codificar suas regras de negócio. 

# imagem da estrutura iniical do projeto

2 Criar um Controller Spring MVC 
Para os propósitos da nossa aplicação vamos criar um Controller (HelloWordController.java):

package com.example.helloWorld;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
	
       @GetMapping("/saudacao")
	public String ola(@RequestParam(name="nome", required=false, defaultValue="World") String nome, Model model) {

		model.addAttribute("nome", nome);		
		return "saudacao";
         }
}


3 Thymeleaf ViewResolver Configuration
O Spring boot configurará automaticamente o Thymeleaf como view resolver e selecionará os Template Mode Thymeleaf (páginas HTML) que encontrar localizados em resources/templates. 
4 Thymeleaf Template - saudacao.html
Crie o arquivo helloworld.html no diretório resources/templates e altere o conteúdo conforme o código exibido abaixo:

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Aplicação de Saudação</title>
</head>
<body>
	<p><h1 th:text="'Hello, ' + ${nome} + '!'"/></p>
	<p><a href="/saudacao?nome=João">Cumprimentar o João</a></p>
	<p><a href="/saudacao?nome=Maria">Cumprimentar a Maria</a></p>
	<p><a href="/saudacao?nome=Fernando">Cumprimentar o Fernando</a></p>
	<p><a href="/saudacao?nome=Paulo">Cumprimentar o Paulo</a></p>
	<p><a href="/">HOME</a></p>
</body>
</html>


O Trecho xmlns:th="http://www.thymeleaf.org" adiciona capacidade de uso do Thymeleaf no arquivo HTML.
 
A expressão thymeleaf th:text altera a tag html <h1> para que receba o conteúdo do Model repassado pelo HelloWorldController.java. 

Vamos criar uma página inicial (index.html) para nossa aplicação em resources/static :

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aplicação de Saudação</title>
</head>
<body>
	<p>Para acessar a aplicação <a href="/saudacao">CLIQUE AQUI</a></p>
</body>
</html>

5 Rodando a aplicação
Para executar a aplicação rode a classe HelloWorldController.java (classe principal da aplicação, anotada com @SpringBootApplication) como uma Aplicação Java a classe e após o Spring levantar o tomcat acesse no navegador o endereço http://localhost:8080

# imagem do naveador na página inicial da aplicação

Clicando no link CLIQUE AQUI é de se esperar que seja apresentada no navegador a página semelhante a da figura abaixo:

# imagem do naveador na página com a lesi=tagem de nomes

Ao clicar em um link com um nome na página saudacao.html será solicitado (HTTP GET) ao servidor a exibição desta mesma página, porém passando como parâmetro o nome que deseja exibir na tag de saudação Hello, World!

Por hoje é isso, atingimos o objetivo deste tutorial e percebemos que com poucas linhas de código foi possível conhecer conceitos básicos para a programação WEB usando JAVA.

