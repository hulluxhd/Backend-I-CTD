public class Ministro extends Hierarquia{
    private int tipo = 2;
    private String info;
    @Override
    public void verificar(Documento doc) {
        if (doc.getTipo() == this.tipo){
            System.out.println("O ministro pode ler.");
            ler(doc);
        } else if (this.getHierarquiaSeguinte() != null){
            this.getHierarquiaSeguinte().verificar(doc);
        }
    }
}
