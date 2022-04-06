public class Controlador1 extends  Controlador{

    @Override
    public void verificar(Artigo artigo) {
        if (artigo.getLote() >= 1000 && artigo.getLote() <= 2000){
            System.out.println("O lote do item "+ artigo.getNome() + " está DENTRO dos parâmetros");
            this.getControlador.verificar(artigo);
        } else System.out.println("O lote do item "+ artigo.getNome() + " está FORA dos parâmetros");
    }
}
