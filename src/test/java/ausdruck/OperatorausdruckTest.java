package ausdruck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorausdruckTest {

    private Operatorausdruck op1;
    private Operatorausdruck op2;
    private Operatorausdruck op3;


    @BeforeEach
    void setUp(){
        op1 = new Operatorausdruck(new Variable("a"), '+', new Konstante(1));
        op2 = new Operatorausdruck(new Variable("b"), '-', new Konstante(2));
        op3 = new Operatorausdruck(new Variable("a"), '+', new Konstante(1));
    }

    @Test
    void testKonstruktor1(){
       assertEquals(op1,op3);
    }

    @Test
    void testKonstruktor2(){
        assertNotEquals(op1,op2);
    }


}