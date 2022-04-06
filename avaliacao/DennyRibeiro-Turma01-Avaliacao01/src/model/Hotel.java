package model;

public class Hotel {
    private int id;
    private String nomeFilial, rua, numero, cidade, estado;
    private int isFiveStar;

    public Hotel(int id, String nomeFilial, String rua, String numero, String cidade, String estado, int isFiveStar) {
        this.id = id;
        this.nomeFilial = nomeFilial;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.isFiveStar = isFiveStar;
    }

    public Hotel(String nomeFilial, String rua, String numero, String cidade, String estado, int isFiveStar) {
        this.nomeFilial = nomeFilial;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.isFiveStar = isFiveStar;
    }

    public Hotel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFilial() {
        return nomeFilial;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public int getIsFiveStar() {
        return isFiveStar;
    }

    public void setIsFiveStar(int isFiveStar) {
        this.isFiveStar = isFiveStar;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nomeFilial='" + nomeFilial + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", isFiveStar=" + isFiveStar +
                '}';
    }
}
