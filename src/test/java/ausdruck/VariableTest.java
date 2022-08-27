package ausdruck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableTest {

    @Test
    void testKonstruktor(){
        Variable v = new Variable("ab");
        assertEquals(v, new Variable("ab"));
    }

    @Test
    void testKonstruktor2(){
        Variable v = new Variable("ab");
        Variable w = new Variable("cd");
        assertNotEquals(v,w);
    }

    @Test
    void testKonstruktor3(){
        Variable v = new Variable("ab");
        Variable w = v;
        assertEquals(v,w);
    }


}