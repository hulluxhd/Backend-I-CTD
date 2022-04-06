public class Main {
    public static void main(String[] args) {
        Artigo a1 = new Artigo("Leite", 1500, 1333, "Saudavel");
        CheckQuality handlerCheck = new CheckQuality();
        handlerCheck.verificar(a1);
    }
}
