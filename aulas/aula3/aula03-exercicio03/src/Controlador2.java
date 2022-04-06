public class Controlador2 extends Controlador{

    @Override
    public void verificar(Artigo artigo) {
        if (artigo.getPeso() >= 1200 && artigo.getPeso() <= 1300){
            System.out.println("O peso do item "+ artigo.getNome() + " está DENTRO dos parâmetros");
            this.getControlador.verificar(artigo);
        } else System.out.println("O peso do item "+ artigo.getNome() + " está FORA dos parâmetros");
    }

}
