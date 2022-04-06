import model.Favorito;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Programa {
    public static void main(String[] args) {

        // criar as listas e instanciar os favoritos

        Favorito f1 = new Favorito("teste.com.br", "teste1");
        Favorito f2 = new Favorito("teste2.com.br", "teste2");

        List<Favorito> favoritoListOutput = new ArrayList<>();
        List<Favorito> favoritoListInput = new ArrayList<>();

        // adicionando instancias as listas
        favoritoListOutput.add(f1);
        favoritoListOutput.add(f2);

        // instanciar FileInput e FileOutput
        FileOutputStream fo = null;
        FileInputStream fi = null;

        // try catch para output

        try{
            fo = new FileOutputStream("listaFavoritos.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(favoritoListOutput);
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // try catch para input
        try{
            fi = new FileInputStream("listaFavoritos.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            favoritoListInput = (ArrayList) ois.readObject();


        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        for (Favorito f: favoritoListInput) {
            System.out.println(f.getNome() + " - " + f.getUrl());

        }
    }
}
