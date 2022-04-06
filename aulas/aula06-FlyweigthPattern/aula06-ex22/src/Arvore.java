import java.util.Locale;

public class Arvore {
    private int largura, altura;
    private String cor, tipo;

    public Arvore(String tipo) {
        this.tipo = tipo;


    }

    public void definirArvore(String tipo){
        if (tipo == "Ornamental".toLowerCase(Locale.ROOT)){
            this.setAltura(200);
            this.largura = 400;
            this.setCor("Verde");
        } else if (tipo == "Frutifera".toLowerCase(Locale.ROOT)){
            this.altura = 500;
            this.largura = 300;
            this.setCor("Vermelho");

        } else if (tipo == "Florifera".toLowerCase(Locale.ROOT)){
            this.altura = 100;
            this.largura = 200;
            this.cor = "Azul".toLowerCase(Locale.ROOT);
        };
    }


    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
