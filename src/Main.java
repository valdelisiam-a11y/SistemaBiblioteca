
public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(10);

        // Cadastro dos itens
        Livro livro1 = new Livro("L001", "A Fortaleza");
        Livro livro2 = new Livro("L002", "Capitães de areia");
        Livro livro3 = new Livro("L003", "Dom Casmurro");
        Revista revista1 = new Revista("R001", "Super Interessante");
        DVD dvd1 = new DVD("D001", "O Auto da Compadecida");

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(livro3);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(dvd1);

        // Cadastro dos usuários
        Aluno aluno = new Aluno("Ana");
        Professor professor = new Professor("Val");

        System.out.println("\n=== EMPRÉSTIMOS DA ALUNA ===");

        // Três empréstimos reais para Ana
        biblioteca.emprestar(livro1, aluno);
        biblioteca.emprestar(livro2, aluno);
        biblioteca.emprestar(livro3, aluno);

        // Quarto empréstimo: deve ser recusado
        biblioteca.emprestar(revista1, aluno);

        System.out.println("\n=== EMPRÉSTIMO DO PROFESSOR ===");

        // O professor consegue pegar a revista
        biblioteca.emprestar(revista1, professor);
        biblioteca.emprestar(dvd1, professor);

        System.out.println("\n=== DEVOLUÇÃO ===");

        // Ana devolve um dos livros emprestados
        biblioteca.devolver(livro1, aluno);

        // Ana volta a ter espaço para outro empréstimo
        biblioteca.emprestar(livro1, aluno);

        System.out.println("\n=== ACERVO FINAL ===");

        biblioteca.listarAcervo();
    }
}
