package model;

public class Roupa {
    private String tamanho, tipo;
    private boolean isNew, isImported;
    private int cont1, cont2 = 0;
    public Roupa(String tamanho, String tipo, boolean isNew, boolean isImported) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.isNew = isNew;
        this.isImported = isImported;
    }

    public int importadaKey(){
       return cont1++;
    }
    public int isNewKey(){
        return cont2++;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }
}
