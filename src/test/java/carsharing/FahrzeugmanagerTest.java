package carsharing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FahrzeugmanagerTest {
    private Fahrzeugmanager m;

    @BeforeEach
    void setUp(){
        m = new Fahrzeugmanager();

        m.fuegeFahrzeugHinzu("Rathaus 1", "Rathaus");
        m.fuegeFahrzeugHinzu("Bahnhof 1", "Bahnhof");
        m.fuegeFahrzeugHinzu("Bahnhof 2", "Bahnhof");
        m.fuegeFahrzeugHinzu("Bahnhof 3", "Bahnhof");

        m.bucheFahrzeug("Bahnhof 1", "2005/04/14, 20:00", "2005/04/15, 08:00");
        m.bucheFahrzeug("Bahnhof 1", "2005/04/15, 18:00", "2005/04/16, 00:00");
        m.bucheFahrzeug("Bahnhof 2", "2005/04/14, 11:00", "2005/04/15, 12:00");
        m.bucheFahrzeug("Bahnhof 3", "2005/04/15, 10:00", "2005/04/15, 19:00");
    }

    @Test
    void testGibFahrzeugNamen1(){
        ArrayList<String> soll = new ArrayList<>();
        soll.add("Bahnhof 1");
        soll.add("Bahnhof 2");
        soll.add("Bahnhof 3");
        soll.add("Rathaus 1");

        assertEquals(soll, m.gibFahrzeugnamen());

    }

    @Test
    void testGibFahrzeugNamen2(){
        ArrayList<String> soll = new ArrayList<>();
        soll.add("Bahnhof 1");
        soll.add("Bahnhof 2");
        soll.add("Bahnhof 3");

        assertEquals(soll, m.gibFahrzeugnamen("Bahnhof"));

    }

    @Test
    void testGibFahrzeugNamen3(){
        ArrayList<String> soll = new ArrayList<>();

        soll.add("Rathaus 1");

        assertEquals(soll, m.gibFahrzeugnamen("Rathaus"));

    }

    @Test
    void testGibVerfuegbareFahrzeuge1(){
        ArrayList<String> soll = new ArrayList<>();

        assertEquals(soll, m.gibVerfuegbareFahrzeuge("Bahnhof", "2005/04/15, 11:30", "2005/04/15, 19:00"));
    }

    @Test
    void testGibVerfuegbareFahrzeuge2(){
        ArrayList<String> soll = new ArrayList<>();
        soll.add("Bahnhof 1");
        soll.add("Bahnhof 2");

        assertEquals(soll, m.gibVerfuegbareFahrzeuge("Bahnhof", "2005/04/15, 12:00", "2005/04/15, 18:00"));
    }

    @Test
    void testGibVerfuegbareFahrzeuge3(){
        ArrayList<String> soll = new ArrayList<>();
        soll.add("Bahnhof 2");
        soll.add("Bahnhof 3");

        assertEquals(soll, m.gibVerfuegbareFahrzeuge("Bahnhof", "2005/04/15, 19:15", "2005/04/15, 23:00"));
    }

    @Test
    void testBucheFahrzeug1(){
        assertTrue(m.bucheFahrzeug("Bahnhof 3", "2005/04/15, 09:00", "2005/04/15, 10:00"));
    }

    @Test
    void testBucheFahrzeug2(){
        m.bucheFahrzeug("Bahnhof 3", "2005/04/15, 09:00", "2005/04/15, 10:00");
        assertFalse(m.bucheFahrzeug("Bahnhof 3", "2005/04/15, 09:00", "2005/04/15, 11:00"));
    }

    @Test
    void testBucheFahrzeug3(){
        assertFalse(m.bucheFahrzeug("Bahnhof 3", "2005/04/15, 11:00", "2005/04/15, 18:00"));
    }

    @Test
    void testBucheFahrzeug4(){
        assertFalse(m.bucheFahrzeug("Bahnhof 3", "2005/04/15, 18:00", "2005/04/15, 20:00"));
    }

    @Test
    void testBucheFahrzeug5(){
        assertTrue(m.bucheFahrzeug("Bahnhof 3", "2005/04/15, 19:00", "2005/04/15, 20:00"));
    }

    @Test
    void testBucheFahrzeug6(){
        m.bucheFahrzeug("Bahnhof 3", "2005/04/15, 19:00", "2005/04/15, 20:00");
        assertFalse(m.bucheFahrzeug("Bahnhof 3", "2005/04/15, 09:00", "2005/04/15, 20:00"));
    }
}