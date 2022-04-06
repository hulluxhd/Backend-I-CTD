public class Deputado extends Hierarquia{
    private int tipo = 1;

    @Override
    public void verificar(Documento doc) {
        if (doc.getTipo() == this.tipo){
            System.out.println("O deputado pode ler.");
            ler(doc);
        } else if (this.getHierarquiaSeguinte() != null){
            this.getHierarquiaSeguinte().verificar(doc);
        }
    }


}
