package zahlenfolge;

import org.junit.jupiter.api.Test;

/**
 * Testklasse für Methoden der Klasse EindeutigeFolge.
 */
public class EindeutigeFolgeTest {

    /**
     * Testet Methoden hatNaechstes und gibNaechstes.
     */
    @Test
    void testZugriffAufFolge1() {

        ZahlenfolgeTestUtil.testZugriffAufFolge(
                new EindeutigeFolge(new EndlicheFolge(new int[0])),
                new Integer[0],
                false);
    }
    
    /**
     * Testet Methoden hatNaechstes und gibNaechstes.
     */

    @Test
    void testZugriffAufFolge2() {

        ZahlenfolgeTestUtil.testZugriffAufFolge(
                new EindeutigeFolge(
                    new EndlicheFolge(new int[]{0, 0, 0, 1, 2, 3, 3, 4, 4})),
                new Integer[]{0, 1, 2, 3, 4},
                true);
    }
    
    /**
     * Testet Methoden hatNaechstes und gibNaechstes.
     */
    @Test
    void testZugriffAufFolge3() {

        ZahlenfolgeTestUtil.testZugriffAufFolge(
                new EindeutigeFolge(new FibonacciFolge()),
                new Integer[]{0, 1, 2, 3, 5},
                true);
    }
}
