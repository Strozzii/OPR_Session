package katalog_lernen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
        ArrayList<Katalogartikel> soll = new ArrayList<>();
        soll.add(artikel_1);
        assertEquals(soll, katalog.gibTreffer1("a1"));
    }

    @Test
    void testGibTreffer2(){
        ArrayList<Katalogartikel> soll = new ArrayList<>();
        soll.add(artikel_1);
        soll.add(artikel_2);
        assertEquals(soll, katalog.gibTreffer2("a"));
    }

    @Test
    void testGibTreffer0(){
        ArrayList<Katalogartikel> soll = new ArrayList<>();
        assertEquals(soll, katalog.gibTreffer3("b"));
    }

    @Test
    void testGibArtikelliste() {
        assertEquals("a1\na2\n", katalog.gibListe());
    }

}