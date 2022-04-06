import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckQualityTest {



    @Test
    void check(){
        CheckQuality c1;
        CheckQuality c2;
        CheckQuality c3;
        Artigo a1, a2, a3;
        c1 = new CheckQuality();
        c2 = new CheckQuality();
        c3 = new CheckQuality();
        a1 = new Artigo("Leite", 1000, 1200, "Quase saudavel");
        a2 = new Artigo("Margarina", 1200, 1200, "");
        a3 = new Artigo("Leite condensado", 100, 100, " saudavel");

        c1.verificar(a1);
        c2.verificar(a2);
        c3.verificar(a3);
    }

}