package service;

import model.Roupa;

import java.util.HashMap;

public class RoupaFactory {
    private HashMap tamanhoXS;
    private HashMap tamanhoS;
    private HashMap tamanhoM;
    private HashMap importadas;
    private HashMap masCondicoes;

    public RoupaFactory() {
        tamanhoM = new HashMap<String, Roupa>();
        tamanhoXS = new HashMap<String, Roupa>();
        tamanhoS = new HashMap<String, Roupa>();
        importadas = new HashMap<String, Roupa>();
        masCondicoes = new HashMap<String, Roupa>();
    }

    public Roupa addRoupa(Roupa roupa){

        if (!(tamanhoM.containsKey(roupa.getTamanho()) || tamanhoXS.containsKey(roupa.getTamanho()) || tamanhoS.containsKey(roupa.getTamanho()))){
            if (roupa.getTamanho().equals("M")){
                tamanhoM.put(roupa.getTamanho(), roupa);
                System.out.println("Adicionado a lista M");
                if (roupa.isImported()) {
                    importadas.put(roupa.importadaKey(), roupa);
                    System.out.println("Adicionado a lita de importados");
                }
                if (!roupa.isNew()){
                    masCondicoes.put(roupa.isNewKey(), roupa);
                    System.out.println("Adicionado a lista de más condições");
                }
                return roupa;
            }
            if (roupa.getTamanho().equals("XS")){
                tamanhoM.put(roupa.getTamanho(), roupa);
                System.out.println("Adicionado a lista XS");

                if (roupa.isImported()){
                    importadas.put(roupa.importadaKey(), roupa);
                    System.out.println("Adicionado a lita de importados");
                }
                if (!roupa.isNew()){
                    masCondicoes.put(roupa.isNewKey(), roupa);
                    System.out.println("Adicionado a lista de más condições");

                }
                return roupa;
            }
            if (roupa.getTamanho().equals("S")){
                tamanhoM.put(roupa.getTamanho(), roupa);
                System.out.println("Adicionado a lista S");

                if (roupa.isImported()){
                    importadas.put(roupa.importadaKey(), roupa);
                    System.out.println("Adicionado a lita de importados");

                }
                if (!roupa.isNew()){
                    masCondicoes.put(roupa.isNewKey(), roupa);
                    System.out.println("Adicionado a lista de más condições");

                }
            }
            return roupa;

        } else System.out.println("Já em memória");
        System.out.println();
        return null;
    }


    public HashMap getTamanhoXS() {
        return tamanhoXS;
    }

    public void setTamanhoXS(HashMap tamanhoXS) {
        this.tamanhoXS = tamanhoXS;
    }

    public HashMap getTamanhoS() {
        return tamanhoS;
    }

    public void setTamanhoS(HashMap tamanhoS) {
        this.tamanhoS = tamanhoS;
    }

    public HashMap getTamanhoM() {
        return tamanhoM;
    }

    public void setTamanhoM(HashMap tamanhoM) {
        this.tamanhoM = tamanhoM;
    }

    public HashMap getImportadas() {
        return importadas;
    }

    public void setImportadas(HashMap importadas) {
        this.importadas = importadas;
    }

    public HashMap getMasCondicoes() {
        return masCondicoes;
    }

    public void setMasCondicoes(HashMap masCondicoes) {
        this.masCondicoes = masCondicoes;
    }
}
