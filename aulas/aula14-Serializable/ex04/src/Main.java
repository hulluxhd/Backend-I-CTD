import model.Contato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contato> listaDeContatos = new ArrayList<>();
        Contato c1 = new Contato("Denny", "denny.ribeiro@outlook.com", "85981385830");
        Contato c2 = new Contato("Joyce", "joycelrleylane@gmail.com", "8599823023");

        listaDeContatos.add(c1);
        listaDeContatos.add(c2);

        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream("Lista-de-contatos.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaDeContatos);
        } catch (Exception e){
            e.getMessage();
        }

        FileInputStream fis = null;
        List<Contato> contatoListReturned = new ArrayList<>();
        try{
            fis = new FileInputStream("Lista-de-contatos.txt");
            BufferedInputStream ois = new BufferedInputStream(fis, 1024);
             contatoListReturned = (ArrayList) ois.read();
            System.out.println(contatoListReturned);
            for (Contato c: contatoListReturned) {
                System.out.println(c.getNome() + " - " + c.getEmail());
            }


        } catch (Exception e){
            e.getMessage();
        }



    }
}
