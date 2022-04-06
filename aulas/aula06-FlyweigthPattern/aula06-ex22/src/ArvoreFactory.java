import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {
    private static final Map<String, Arvore> floresta = new HashMap<>();

    public Arvore getArvore(String tipo){
        String tipoArvore = tipo;
        if (!floresta.containsKey(tipoArvore)){
            floresta.put(tipo, new Arvore(tipoArvore));
            floresta.get(tipoArvore).definirArvore(tipoArvore);
            System.out.println("Adicionado; cor: " + floresta.get(tipo).getCor());
            return floresta.get(tipo);
        }
        System.out.println("Já na memória; cor: " + floresta.get(tipo).getCor());
        return floresta.get(tipo);

    }
}
