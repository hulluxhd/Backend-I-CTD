public class Main {
    public static void main(String[] args) {
        Vendedor v1 = new Vendedor("Denny");
        v1.realizarVenda(10);

        v1.obterAfiliado(new Afiliado("Teste"));
        v1.mostrarCategoria();

        Afiliado af1 = new Afiliado("Joyce");
        Funcionario a1 = v1.obterAfiliado(af1);
        a1.realizarVenda(5);

        a1.mostrarCategoria();


        System.out.println(v1.getNome());

        System.out.println(v1.getQuantidadeVendas());

        Estagiario e1 = new Estagiario("Marcos");
        e1.realizarVenda(100);
        e1.mostrarCategoria();


    }
}
