
public class Livro extends ItemBiblioteca {

    public Livro(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int prazoEmprestimo() {
        return 14;
    }

    @Override
    public double multaDiaria() {
        return 0.50;
    }
}
