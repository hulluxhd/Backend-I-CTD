package aula02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {
    @Test
    void Calculos(){
        Funcionario func = new Efetivo("Denny", "Ribeiro", "223344", 3000.0, 600.0, 400.0);
        func.pagamanentoSalario();

        func = new Contratado("Joyce", "Leylane", "221122", 60, 180);
        func.pagamanentoSalario();
    }
    @Test
    void test(){
        asser
    }
}