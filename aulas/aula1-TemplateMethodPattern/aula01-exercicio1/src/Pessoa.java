import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    List<String> nomes = new ArrayList();
    LocalDate idade;
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public List<String> adicionarNome(Pessoa p){
        int qtdCaracteres = p.getNome().length();
        int idade = p.calcIdade();

        if (qtdCaracteres >= 5 && idade > 17){
            this.nomes.add(p.getNome());
            System.out.println(this.getNomes());
        }
        return  null;
    }


    public int calcIdade(){
        int idade = Period.between(this.getIdade(),
                LocalDate.of(2022, 02, 21)).getYears();
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idade=" + idade +
                ", nome='" + nome + '\'' +
                '}';
    }

    //getters and setters

    public List<String> getNomes() {
        return nomes;
    }

    public void setNomes(List<String> nomes) {
        this.nomes = nomes;
    }

    public LocalDate getIdade() {
        return idade;
    }

    public void setIdade(LocalDate idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}



