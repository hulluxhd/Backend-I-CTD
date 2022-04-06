import model.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        List<Cachorro> listaCachorros = new ArrayList<>();
        Cachorro c1 = new Cachorro();
        c1.setNome("Graham");
        c1.setIdade(1);
        c1.setRaca("Vira-lata");
        c1.setEndereco("Casa da Joyce");

        listaCachorros.add(c1);
        System.out.println(listaCachorros.indexOf(c1));
        System.out.println(listaCachorros.get(0));

        //Salvar a coleção Cachorros em um arquivo

        // instanciar FileOutputStream
        FileOutputStream foo = null;
        try{

            foo = new FileOutputStream("docs.dat");
            ObjectOutputStream oos = new ObjectOutputStream(foo);
            oos.writeObject(listaCachorros);
            oos.close();
            foo.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        // ler arquivos
        // instanciar FileInputStrem
        List<Cachorro> cachorroList = new ArrayList<>();
        FileInputStream fis = null;

        try {
            // pega o arquivo (File)
            fis = new FileInputStream("docs.dat");
            // cria um objeto que salvará as informações de File
            ObjectInputStream ois = new ObjectInputStream(fis);
            // lê as informações capturadas em 'ois' e salva em cachorroList
            cachorroList = (ArrayList) ois.readObject();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        for (Cachorro c: cachorroList) {
            System.out.println(
                    c.getNome() + " | " +
                    c.getRaca() + " | " +
                    c.getEndereco() + " | " +
                    c.getIdade());
        }

    }
}
