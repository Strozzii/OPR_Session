package katalog_lernen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuchTest {

    private Buch b1;

    @BeforeEach
    void setUp(){
        b1 = new Buch("Hobbit", "Tolkien", 25, 1937);
    }

    @Test
    void testGibText(){
        String soll = "Hobbit; Tolkien; 1937; €25";
        assertEquals(soll, b1.gibText());
    }

}