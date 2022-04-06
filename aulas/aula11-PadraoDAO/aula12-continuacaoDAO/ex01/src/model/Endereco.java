package model;

public class Endereco {
    private int id;
    private int numero;
    private String rua;
    private String cidade;
    private String estado;

// criando todas as possibilidades de construtores


    public Endereco(int id, int numero, String rua, String cidade, String estado) {
        this.id = id;
        this.numero = numero;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco() {
    }

    public Endereco(int numero, String rua, String cidade, String estado) {
        this.numero = numero;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", numero=" + numero +
                ", rua='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
