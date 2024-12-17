# Sistema de Avaliação de Filmes

Este é um projeto desenvolvido como parte de uma atividade acadêmica para uma casa cultural, onde os usuários podem cadastrar filmes e realizar análises sobre eles. O sistema foi implementado utilizando Spring MVC e é projetado para armazenar dados em memória, sem a necessidade de um banco de dados.

## Funcionalidades

- **Cadastro de Filmes**: Permite que os usuários adicionem novos filmes ao sistema informando título, sinopse, gênero e ano de lançamento.
- **Listagem de Filmes**: Mostra todos os filmes cadastrados com a opção de visualizar detalhes.
- **Análise de Filmes**: Permite que os usuários adicionem análises e notas aos filmes já cadastrados.
- **Visualização de Detalhes**: Exibe informações completas sobre um filme específico, incluindo suas análises.

## Estrutura do Projeto

O projeto é dividido em duas entidades principais:

1. **Filme**
   - `id`: Identificador único do filme.
   - `titulo`: Título do filme.
   - `sinopse`: Breve descrição da trama.
   - `genero`: Gênero do filme.
   - `ano`: Ano de lançamento.

2. **Análise**
   - `id`: Identificador único da análise.
   - `filme`: Referência ao filme analisado.
   - `analise`: Texto da análise.
   - `nota`: Nota atribuída ao filme.

## Tecnologias Utilizadas

- Java 
- Spring MVC
- HTML/CSS
- Tomcat (servidor web)

## Pré-requisitos

- JDK 11 ou superior
- Apache Maven
- NetBeans ou IDE de sua escolha
