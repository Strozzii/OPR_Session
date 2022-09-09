package katalog_lernen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KatalogartikelTest {

    private Katalogartikel katalogartikel;

    @BeforeEach
    void setUp(){
        katalogartikel = new MockKatalogartikel("das diebesgut");
    }

    @Test
    void testPasstZuWortanfangAusschlusswort(){
        assertFalse(katalogartikel.passtZu("da"));
    }

    @Test
    void testPasstZuWortanfang() {
        assertTrue(katalogartikel.passtZu("die"));
    }

    @Test
    void testPasstZuDerDieDas(){
        Katalogartikel artikel = new MockKatalogartikel("der die das");
        assertFalse(artikel.passtZu("die"));
    }

}