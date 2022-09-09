package katalog_lernen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class BuchTest {

    private Buch buch;

    @BeforeEach
    void setUp(){
        buch = new Buch("Asterix der Gallier", "Uderzo", 9.80f, 1965);
    }

    @Test
    void testGibText(){
        assertEquals("Asterix der Gallier; Uderzo; 1965; €9.8", buch.gibText());
    }

    @Test
    void testGibSuchtext(){
        assertEquals("Asterix der Gallier Uderzo", buch.gibSuchtext());
    }

}