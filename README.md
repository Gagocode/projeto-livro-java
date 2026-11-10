# Projeto Livro em Java

Projeto academico simples de Programacao Orientada a Objetos que representa
pessoas, livros e a navegacao pelas paginas de uma publicacao.

## Conceitos demonstrados

- abstracao e encapsulamento;
- construtores, getters e setters;
- interface e implementacao;
- agregacao entre `Livro` e `Pessoa`;
- controle de estado e limites de navegacao;
- demonstracao dos comportamentos em um metodo `main`.

## Estrutura do projeto

Os codigos-fonte ficam no diretorio `src/`:

- `Pessoa.java`: dados e comportamentos de uma pessoa;
- `Publicacao.java`: contrato para operacoes de uma publicacao;
- `Livro.java`: livro associado a uma pessoa leitora;
- `Principal.java`: demonstracao executavel da aplicacao.

## Pre-requisitos

- JDK 8 ou superior, com os comandos `javac` e `java` disponiveis no
  terminal.

O projeto nao utiliza bibliotecas externas nem ferramenta de build.

## Compilacao e execucao

No PowerShell, a partir da raiz do projeto:

```powershell
javac -d out src\*.java
java -cp out Principal
```

O programa demonstra a criacao de pessoas e livros, a abertura e o
fechamento de um livro, a navegacao valida entre paginas e a preservacao do
estado quando uma pagina invalida e solicitada.

## Testes

Os testes automatizados nao dependem de bibliotecas externas. Para compilar o
projeto e executar todos os cenarios verificados:

```powershell
javac -Xlint:all -d out src\*.java test\TesteAplicacao.java
java -ea -cp out TesteAplicacao
```
