![Logo](https://github.com/douglas-goncalves/acelera_assets/blob/master/logo.jpeg)
# Api aceleraGep Biblioteca
[![shield-mit](https://img.shields.io/badge/license-MIT-green)](https://github.com/douglas-goncalves/acelera_assets/blob/master/docs/LICENCE)
# Sobre o Projeto
Este é o primeiro projeto de avaliação do Acelera ao qual o tema é biblioteca.

# Tecnologias Utilizadas
- Spring boot
- Hibernate
- Mysql
- Swagger
- Java 17

# Como Executar o projeto

## Backend
# Pré-requisitos:
- Java 17

# Como importar e levantar o projeto

 1. Clonar Repositório
```Banch
git clone https://github.com/douglas-goncalves/api-acelera-biblioteca.git
```
 2. Abrir o Springtool, Eclipse ou outro de sua preferência.
 3. Importar o projeto
 4. Será Necessário Configurar o application.properties do projeto ou definir algumas variáveis de sistema:
 ![application_properties1](https://github.com/douglas-goncalves/acelera_assets/blob/master/application-properties.png)
 
 #### Host, Porta, Schema, Usuario e Password
  ```Banch
  DATABASE_HOST
  ```
  ```Banch
  DATABASE_PORT
  ```
  ```Banch
  DATABASE_NAME
  ```
  ```Banch
  DATABASE_USER
  ```
  ```Banch
  DATABASE_PASSWORD 
  ```
   - Um Exemplo para caso resolva não usar as variaveis de sistema
 ![application_properties2](https://github.com/douglas-goncalves/acelera_assets/blob/master/application-properties_exemplo.png)
  
 ## Requisições e Objetos Json usadas no Postman:
 
### AutorEntity:
#### Lista todos:
 ```Banch
http://localhost:8080/api/autores?page=0&size=10&sort=id,asc
```
Busca pelo id:
 ```Banch
http://localhost:8080/api/autores/{idAutor}
```
Deleta: 
 ```Banch
http://localhost:8080/api/autores/{idAutor}
```
Cadastra:
 ```Banch
http://localhost:8080/api/autores
```
~~~json
{
	"nome":"String",
	"bibliografia":"String"
}
~~~

Atualiza:
 ```Banch
http://localhost:8080/api/autores/{idAutor}
```
~~~json
{
	"nome":"String",
	"bibliografia":"String"
}
~~~

Lista os Livro pelo id do autor:
 ```Banch
http://localhost:8080/api/autores/{idAutor}/livros?page=0&size=10&sort=id,asc
```
### LivroEntity:
#### Lista todos: 
 ```Banch
http://localhost:8080/api/livros?page=0&size=10&sort=id,asc
```
Busca pelo id: 
 ```Banch
http://localhost:8080/api/livros/{idLivro}
```
Deleta: 
 ```Banch
http://localhost:8080/api/livros/{idLivro}
```
Cadastra: 
 ```Banch
http://localhost:8080/api/livros
```
~~~json
{
	"titulo":"String",
	"anoLancamento":"Int",
	"autores":[1,2,3,...N]
}
~~~
Atualiza: 
 ```Banch
http://localhost:8080/api/livros/{idLivro}
```
~~~json
{
	"titulo":"String",
	"anoLancamento":"Int",
	"autores":[1,2,3,...N]
}
~~~
# Swagger
### O Swagger esta incorporado ao projeto usando Dependencias (**springdoc-openapi-ui** e **springdoc-openapi-data-rest**) no pom.xml
Para Acessar a documentação será necessario levantar a aplicação e usar o URL a baixo para acessá-la.

<a href= "http://localhost:8080/swagger-ui/index.html#/">
	http://localhost:8080/swagger-ui/index.html#/
</a>



# Modelo Entidade Relacionameto:
![mer](https://github.com/douglas-goncalves/acelera_assets/blob/master/mer.png)



# Auto
Douglas Goncalves
