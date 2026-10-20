
public class Biblioteca {

    private ItemBiblioteca[] acervo;
    private ItemBiblioteca[] itensEmprestados;
    private Usuario[] usuariosEmprestimos;
    private int quantidadeItens;

    public Biblioteca(int capacidade) {
        acervo = new ItemBiblioteca[capacidade];
        itensEmprestados = new ItemBiblioteca[capacidade];
        usuariosEmprestimos = new Usuario[capacidade];
        quantidadeItens = 0;
    }

    public void cadastrarItem(ItemBiblioteca item) {
        if (item == null) {
            System.out.println("Item inválido.");
            return;
        }

        if (quantidadeItens >= acervo.length) {
            System.out.println("Acervo cheio.");
            return;
        }

        for (int i = 0; i < quantidadeItens; i++) {
            if (acervo[i].getCodigo().equals(item.getCodigo())) {
                System.out.println("Código já cadastrado.");
                return;
            }
        }

        acervo[quantidadeItens] = item;
        quantidadeItens++;

        System.out.println("Item cadastrado: " + item.getTitulo());
    }

    public void emprestar(ItemBiblioteca item, Usuario usuario) {
        if (item == null || usuario == null) {
            System.out.println("Item ou usuário inválido.");
            return;
        }

        boolean cadastrado = false;

        for (int i = 0; i < quantidadeItens; i++) {
            if (acervo[i] == item) {
                cadastrado = true;
                break;
            }
        }

        if (!cadastrado) {
            System.out.println("Empréstimo recusado: item não cadastrado.");
            return;
        }

        if (!item.isDisponivel()) {
            System.out.println("Empréstimo recusado: item indisponível.");
            return;
        }

        if (usuario.getQuantidadeEmprestada() >= usuario.limiteItens()) {
            System.out.println("Empréstimo recusado: limite de itens atingido.");
            return;
        }

        int posicaoLivre = -1;

        for (int i = 0; i < itensEmprestados.length; i++) {
            if (itensEmprestados[i] == null) {
                posicaoLivre = i;
                break;
            }
        }

        if (posicaoLivre == -1) {
            System.out.println("Não há espaço para registrar o empréstimo.");
            return;
        }

        itensEmprestados[posicaoLivre] = item;
        usuariosEmprestimos[posicaoLivre] = usuario;

        item.marcarComoEmprestado();
        usuario.registrarEmprestimo();

        System.out.println(
                "Empréstimo realizado: " + item.getTitulo()
                        + " para " + usuario.getNome()
        );
    }

    public void devolver(ItemBiblioteca item, Usuario usuario) {
        if (item == null || usuario == null) {
            System.out.println("Item ou usuário inválido.");
            return;
        }

        for (int i = 0; i < itensEmprestados.length; i++) {
            if (itensEmprestados[i] == item
                    && usuariosEmprestimos[i] == usuario) {

                itensEmprestados[i] = null;
                usuariosEmprestimos[i] = null;

                item.marcarComoDisponivel();
                usuario.registrarDevolucao();

                System.out.println(
                        "Devolução realizada: " + item.getTitulo()
                );
                return;
            }
        }

        System.out.println(
                "Devolução recusada: empréstimo não encontrado para esse usuário."
        );
    }

    public void listarAcervo() {
        System.out.println("\n=== ACERVO DA BIBLIOTECA ===");

        for (int i = 0; i < quantidadeItens; i++) {
            ItemBiblioteca item = acervo[i];

            System.out.println(
                    "Código: " + item.getCodigo()
                            + " | Título: " + item.getTitulo()
                            + " | Disponível: "
                            + (item.isDisponivel() ? "Sim" : "Não")
                            + " | Prazo: " + item.prazoEmprestimo() + " dias"
                            + " | Multa diária: R$ " + item.multaDiaria()
            );
        }
    }
}
