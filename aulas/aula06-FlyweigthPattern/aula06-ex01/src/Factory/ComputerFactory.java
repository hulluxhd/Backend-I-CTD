package Factory;

import model.Computer;

import java.util.HashMap;
import java.util.Map;

public class ComputerFactory {
    private static Map<String, Computer> macFlyweight = new HashMap<>();

    public Computer getComputer(int ram, int hd){
        String comp = "Comp: " + ram + ";" + hd;
        System.out.println(comp);
        if (!macFlyweight.containsKey(comp)){
            macFlyweight.put(comp, new Computer(ram, hd));
            System.out.println("PC criado");
            return macFlyweight.get(comp);
        }

        System.out.println("PC obtido da memória");
        return macFlyweight.get(comp);
    }
}
