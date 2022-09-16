package klausur_3;

import static org.junit.jupiter.api.Assertions.*;

public class Test {

    @org.junit.jupiter.api.Test
    void test(){

        Exception e = assertThrows(StringIndexOutOfBoundsException.class, () -> "Haus".charAt(4));

        assertEquals("String index out of range: 4", e.getMessage());
    }

}
