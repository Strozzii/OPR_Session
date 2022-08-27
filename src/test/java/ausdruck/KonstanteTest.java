package ausdruck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KonstanteTest {

    @Test
    void testKonstruktor(){
        Konstante k = new Konstante(4);
        assertEquals(k, new Konstante(4));
    }

    @Test
    void testKonstruktor1(){
        Konstante j = new Konstante(4);
        Konstante k = new Konstante(4);
        assertEquals(k, j);
    }

    @Test
    void testKonstruktor2(){
        Konstante k = new Konstante(4);
        Konstante l = k;
        assertSame(k, l);
    }



}