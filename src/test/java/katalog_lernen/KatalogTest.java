package katalog_lernen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KatalogTest {

    private Katalog katalog;
    private Katalogartikel artikel_1;
    private Katalogartikel artikel_2;

    @BeforeEach
    void setUp(){
        katalog = new Katalog();

        artikel_1 = new MockKatalogartikel("a1");
        artikel_2 = new MockKatalogartikel("a2");

        katalog.fuegeHinzu(artikel_1);
        katalog.fuegeHinzu(artikel_2);

    }

    @Test
    void testGibTreffer1(){
        assertArrayEquals(new Katalogartikel[]{artikel_1}, katalog.gibTreffer("a1"));
    }

    @Test
    void testGibTreffer2(){
        assertArrayEquals(new Katalogartikel[]{artikel_1, artikel_2}, katalog.gibTreffer("a"));
    }

    @Test
    void testGibTreffer0(){
        assertArrayEquals(new Katalogartikel[]{}, katalog.gibTreffer("b"));
    }

    @Test
    void testGibArtikelliste() {
        assertEquals("a1\na2\n", katalog.gibListe());
    }

}