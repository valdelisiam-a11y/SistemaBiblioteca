# Sistema de Biblioteca

Projeto desenvolvido em Java e PostgreSQL para praticar programação orientada a objetos, modelagem de banco de dados e consultas SQL.

## Exercício 1 — Java

Implementação de um sistema de biblioteca utilizando conceitos de orientação a objetos:

- Classes abstratas `ItemBiblioteca` e `Usuario`.
- Herança para representar livros, revistas, alunos e professores.
- Polimorfismo para definir prazos de empréstimo e multas.
- Controle de empréstimos, devoluções e disponibilidade dos itens.
- Limites de empréstimos por tipo de usuário.
- Uso de arrays de tamanho fixo para armazenar os dados.

A classe `DVD` foi adicionada como exemplo de extensão do sistema.

### Como executar

1. Abra o projeto no IntelliJ IDEA.
2. Localize a classe `Main.java` dentro da pasta `src`.
3. Execute o método `main` para visualizar os testes de empréstimos, recusas e devoluções.

## Exercício 2 — PostgreSQL

O banco de dados utiliza três tabelas:

- `item`: dados dos itens do acervo.
- `usuario`: dados dos usuários e seus limites de empréstimo.
- `emprestimo`: registros de retirada, devolução e multas.

A modelagem inclui chaves primárias, chaves estrangeiras e restrições de integridade.

### Arquivos SQL

- `sistema_biblioteca.sql`: criação das tabelas e inserção dos dados de teste.
- `consultas.sql`: consultas para listar o acervo, consultar empréstimos em aberto, calcular multas por usuário e localizar itens nunca emprestados.

### Como executar no PostgreSQL

1. Crie um banco de dados chamado `sistema_biblioteca`.
2. Abra o arquivo `sistema_biblioteca.sql` no Query Tool do pgAdmin e execute o script.
3. Execute as consultas do arquivo `consultas.sql` para conferir os resultados.

**Tecnologias utilizadas:** Java, PostgreSQL, pgAdmin 4, IntelliJ IDEA e Git.
