public abstract class Hierarquia {

    protected Hierarquia hierarquiaSeguinte;

    public Hierarquia getHierarquiaSeguinte(){
        return this.hierarquiaSeguinte;
    }

    public void setHierarquiaSeguinte(Hierarquia seguinte){
        this.hierarquiaSeguinte = seguinte;
    }

    public abstract void verificar(Documento doc);

    public void ler(Documento doc) {
        System.out.println(doc.getConteudo());
    }



}
