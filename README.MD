# 👨‍💻Sobre o projeto

Essa API permite com que você faça consultas a um banco de dados que contém todos os 822
pokémons do jogo Pokémon GO.

O projeto foi inspirado em um desafio técnico da [RedFox Tech](https://github.com/RedFoxTech/vaga-backend-teste)
e também nesse site: https://pokemon.gameinfo.io/en/pokemon/.

## 💿Como rodar na sua máquina

### Pré-requisitos

- **Git**;
- **Docker + Docker-Compose (caso queira utilizar Docker)**;
- **Java 17 (caso queira utilizar o Maven)**

<details>
    <summary><b style="font-size:1.4em;">🐳Utilizando Docker</b></summary>

```shell
# Clone o repositório na sua máquina
$ git clone https://github.com/lleonardus/pokemon-go.git

# Abra a pasta do projeto
$ cd pokemon-go

# Inicie o projeto usando Docker
$ docker-compose up
```

Após esse processo, a API vai estar rodando em **http://localhost:8080**.

</details>

<details>
    <summary><b style="font-size:1.4em;">♨️Utilizando Maven</b></summary>

``` shell
# Clone o repositório na sua máquina
$ git clone https://github.com/lleonardus/pokemon-go.git

# Abra a pasta do projeto
$ cd pokemon-go

# Inicie o projeto usando Maven
$ ./mvnw spring-boot:run
```

Após esse processo, a API vai estar rodando em **http://localhost:8080**
e o banco de dados (H2 database) pode ser acessado em **http://localhost:8080/h2-console/**

</details>


## 🎯Endpoints

### 👾Pokémons

- **GET** `/pokemons`: Retorna uma lista paginada que busca pokémons com base nos **parâmetros** passados.

- **GET** `/pokemons/top-attackers`: Retorna uma lista paginada, ordenada pelo **ataque** de cada pokémon.

- **GET** `/pokemons/top-defenders`: Retorna uma lista paginada, ordenada pela **defesa** de cada pokémon.

- **GET** `/pokemons/best-pokemon-by-stat-total`: Retorna uma lista paginada, ordenada pelo **status total** (atk + def + sta)
de cada pokémon.

- **GET** `/pokemons/best-pokemon-by-cp`: Retorna uma lista paginada, ordenada pelo **CP** de cada pokémon.

#### 🔍Query Params🔎
Aqui estão alguns parâmetros que você pode utilizar para **paginar, ordenar e filtrar** suas buscas:
<details>
    <summary><b>page & size</b></summary>
    As consultas são <b>paginadas</b>, o que significa que você pode especificar quantos elementos cada página
    tem, assim como também a página em que está. Para alterar o número da página, utilize o parâmetro
    <b>page</b> e para alterar quantos elementos cada página possui, utilize o parâmetro <b>size</b>.
    Por padrão, page=0 e size=20.
</details>
<details>
    <summary><b>sort</b></summary>
    Através desse parâmetro, é possível escolher como você quer que a consulta seja
    ordenada. Exemplo1: <b>/pokemons?sort=atk,desc</b> retorna uma lista paginada, ordenada
    pelos melhores atacantes do jogo, assim como o endpoint <b>/pokemons/top-attackers</b>.
    Exemplo2: <b>/pokemons?sort=atk,asc</b> retorna uma lista paginada, ordenada
    pelos piores atacantes do jogo.
</details>
<details>
    <summary><b>Parâmetros para filtrar pokémons em /pokemons</b></summary>
    <li><b>name</b> (String)</li>
    <li><b>type</b> (String)</li>
    <li><b>generation</b> (Integer)</li>
    <li><b>familyId</b> (Integer)</li>
    <li><b>notGettable</b> (Boolean)</li>
    <li><b>legendary</b> (Boolean)</li>
</details>

### 👨‍🚀Postman🚀
Caso tenha o **Postman** instalado na sua máquina e queira ver exemplos de **como usar os endpoints**
e os **query params**, importe o arquivo na pasta `postman`.

## 🧰Ferramentas Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Postman
