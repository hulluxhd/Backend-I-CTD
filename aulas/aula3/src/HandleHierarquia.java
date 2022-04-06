public class HandleHierarquia {

    private Hierarquia inicial;

    public HandleHierarquia(){
        this.inicial = new Deputado();
        Hierarquia ministro = new Ministro();
        Hierarquia presidente = new Presidente();

        inicial.setHierarquiaSeguinte(ministro);
        ministro.setHierarquiaSeguinte(presidente);



    }

    public void verificar(Documento doc){
        inicial.verificar(doc);
    }


}
