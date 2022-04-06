public class Presidente extends Hierarquia{
    private int tipo = 3;
    private String info;

    @Override
    public void verificar(Documento doc) {
        if (doc.getTipo() == this.tipo){
            System.out.println("O presidente pode ler.");
            ler(doc);
        } else if (this.getHierarquiaSeguinte() != null){
            this.getHierarquiaSeguinte().verificar(doc);
        }
    }


}
