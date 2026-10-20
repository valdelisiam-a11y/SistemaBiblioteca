
public class Revista extends ItemBiblioteca {

    public Revista(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int prazoEmprestimo() {
        return 7;
    }

    @Override
    public double multaDiaria() {
        return 1.00;
    }
}
