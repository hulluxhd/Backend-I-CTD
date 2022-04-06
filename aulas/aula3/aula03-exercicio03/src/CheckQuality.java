public class CheckQuality {
    Artigo artigo;
    Controlador inicial;
    public CheckQuality() {
        Controlador c1 = new Controlador1(); // Lote
        Controlador c2 = new Controlador2(); // Peso
        Controlador c3 = new Controlador3(); // Embalagem

        inicial = c1;
        c1.setControlador(c2);
        c2.setControlador(c3);

    }

    public void verificar(Artigo artigo){
        inicial.verificar(artigo);
    };
}
