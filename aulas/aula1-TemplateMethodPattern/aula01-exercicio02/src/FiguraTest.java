import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiguraTest {

    Circulo c1, c2, c3;
    Quadrado q1, q2, q3;


    @BeforeEach
    void doBefore(){
        c1 = new Circulo(2);
        c2 = new Circulo(3);
        c3 = new Circulo(1);

        q1 = new Quadrado(1);
        q2 = new Quadrado(1.5);
        q3 = new Quadrado(2);
    }

    @Test
    void testePerimetro(){
        assertEquals(12.566370614359172, c1.calcularPerimetro(), 0.01);
        assertEquals(18.84955592153876, c2.calcularPerimetro(), "Falha");
        assertEquals(6.28, c3.calcularPerimetro(), 0.01);

        assertEquals(4, q1.calcularPerimetro());
        assertEquals(6, q2.calcularPerimetro());
        assertEquals(8, q3.calcularPerimetro());

    }


}