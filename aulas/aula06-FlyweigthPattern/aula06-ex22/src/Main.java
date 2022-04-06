public class Main {
    public static void main(String[] args) {
        ArvoreFactory arvoreFactory = new ArvoreFactory();
        for (int i = 0; i <= 1000; i++){
            arvoreFactory.getArvore("Frutifera");
        }

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));


    }
}
