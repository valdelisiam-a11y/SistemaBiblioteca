
public class DVD extends ItemBiblioteca {

    public DVD(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int prazoEmprestimo() {
        return 3;
    }

    @Override
    public double multaDiaria() {
        return 2.00;
    }
}
