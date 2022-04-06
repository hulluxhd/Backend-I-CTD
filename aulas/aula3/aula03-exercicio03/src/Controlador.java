public abstract class Controlador {

    protected Controlador getControlador;

    public void setControlador(Controlador c){
        this.getControlador = c;
    }

    public abstract void verificar(Artigo artigo);
}
