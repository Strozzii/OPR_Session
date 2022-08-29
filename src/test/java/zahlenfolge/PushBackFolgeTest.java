package zahlenfolge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Testklasse für Methoden der Klasse PushBackFolge.
 */
public class PushBackFolgeTest {

    /**
     * Testet Methoden hatNaechstes und gibNaechstes.
     */
    @Test
    void testZugriffAufFolge1() {

        PushBackFolge folge = new PushBackFolge(new EndlicheFolge(new int[0]));
        ZahlenfolgeTestUtil.testZugriffAufFolge(folge, new Integer[0], false);
    }

    /**
     * Testet Methoden hatNaechstes und gibNaechstes.
     */
    @Test
    void testZugriffAufFolge2() {

        PushBackFolge folge = new PushBackFolge(new EndlicheFolge(new int[0]));
        folge.schreibeZurueck(8);
        folge.schreibeZurueck(5);
        folge.schreibeZurueck(2);
        folge.schreibeZurueck(5);
        ZahlenfolgeTestUtil.testZugriffAufFolge(
                folge,
                new Integer[]{5, 2, 5, 8}, false);
    }

    /**
     * Testet Methoden hatNaechstes und gibNaechstes.
     */
    @Test
    void testZugriffAufFolge3() {

        PushBackFolge folge = new PushBackFolge(new FibonacciFolge());
        assertEquals(0, folge.gibNaechstes());
        assertEquals(1, folge.gibNaechstes());
        folge.schreibeZurueck(-100);
        folge.schreibeZurueck(-200);
        assertEquals(-200, folge.gibNaechstes());
        folge.schreibeZurueck(-300);
        ZahlenfolgeTestUtil.testZugriffAufFolge(
                folge,
                new Integer[]{-300, -100, 1, 2, 3, 5, 8},
                true);
    }
}
