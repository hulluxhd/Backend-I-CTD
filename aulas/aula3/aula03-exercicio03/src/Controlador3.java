public class Controlador3 extends Controlador{

    @Override
    public void verificar(Artigo artigo) {
        if (artigo.getEmbalagem().equalsIgnoreCase("Saudavel") || artigo.getEmbalagem().equalsIgnoreCase("quase saudavel")){
            System.out.println("A embalagem do item "+ artigo.getNome() + " está DENTRO dos parâmetros");
            System.out.println("Parabéns, seu artigo cumpre todos os requisitos!");;
        } else System.out.println("A embalagem do item "+ artigo.getNome() + " está FORA dos parâmetros");
    }
}
