import model.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Graham", 1);
        Cachorro cachorro1 = new Cachorro("Sansa", 6);
        Cachorro cachorro2 = new Cachorro("lala", 5);


        List<Cachorro> cachorroList = new ArrayList<>();

        cachorroList.add(cachorro);
        cachorroList.add(cachorro1);
        cachorroList.add(cachorro2);

        // output
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("cachorroList.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cachorroList);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // input
        FileInputStream fis = null;
        List<Cachorro> cachorroList1 = new ArrayList<>();
        try {
            fis = new FileInputStream("cachorroList.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            cachorroList1 = (ArrayList) ois.readObject();
        } catch (FileNotFoundException e){
            e.getMessage();
        } catch (Exception e){
            e.getMessage();
        }

        for (Cachorro c : cachorroList1) {
            System.out.println(c.getNome() + " - " + c.getIdade() + " ano");

        }
    }
}
