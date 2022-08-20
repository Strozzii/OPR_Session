package string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StringTest {

    private String s;
    private String t;
    private String r;


    @BeforeEach
    void setUp(){
        s = "0123456789";
        t = "9876543210";
        r = "0123456789";
    }

    @Test
    void testSubstring1(){
        assertEquals("234", s.substring(2,5), "Scheitze");
    }

    @Test
    void testSubstring2(){
        assertThrows(IndexOutOfBoundsException.class, () -> s.substring(0,12));
    }

    @Test
    void testSubstring3(){
        assertNotSame(r.substring(3,6), s.substring(3,6));
    }

    @Test
    void testSubstring4(){
        assertSame("0123456789", s.substring(0,10), "Scheitze");
    }


}
