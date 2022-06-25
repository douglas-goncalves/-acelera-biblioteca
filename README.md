![Logo](https://github.com/douglas-goncalves/acelera_assets/blob/master/logo.jpeg)
# Api aceleraGep Biblioteca
# Sobre o Projeto
Este é o primeiro projeto de avalização do Acelera ao qual o tema é biblioteca.

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
 2. Abra o Springtool, Eclipse ou outro de sua preferência.
 3. Import o projeto
 4. Será Necessário Configurar o application.properties do projeto ou definir algumas variáveis de sistema:
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
 ## Requisições:
 
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
	"autores":[1,2,3,.,.,.]
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
	"autores":[1,2,3,.,.,.]
}
~~~
# Swagger
### O Swagger esta incorporado ao projeto usando Dependencias (**springdoc-openapi-ui** e **springdoc-openapi-data-rest**) no pom.xml
Logo após o projeto estive levantado use o link a baixo para acessá-lo.
<http://localhost:8080/swagger-ui/index.html#/>

# Modelo Entidade Relacionameto:
![mer](https://github.com/douglas-goncalves/acelera_assets/blob/master/mer.png)



# Auto
Douglas Goncalves
