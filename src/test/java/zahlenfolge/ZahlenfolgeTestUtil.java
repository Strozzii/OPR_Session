package zahlenfolge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Hilfsklasse zum Test von Klassen, die die Schnittstelle
 * Zahlenfolge implementieren.
 */
public class ZahlenfolgeTestUtil {

    /**
     * Testet die übergebene Folge. Die ersten n Elemente der Folge müssen
     * mit den Werten im Feld der Sollelemente übereinstimmen (n ist hierbei
     * die Länge dieses Felds). Danach darf es noch ein weiteres Element
     * geben oder nicht.
     * 
     * @param folge  Folge, die getestet wird
     * @param sollElemente  die erwarteten nächsten Elemente der Folge
     * @param sollHatNaechsten  true genau dann, wenn Folge noch ein weiteres
     *        Element enthalten darf, nachdem n Elemente abgerufen wurden
     */
    public static void testZugriffAufFolge(Zahlenfolge folge,
                                           Integer[] sollElemente,
                                           boolean sollHatNaechsten) {

        ArrayList<Integer> istElemente = new ArrayList<>();

        for (int i = 0; i < sollElemente.length; i++) {

            /* Durch hatNaechstes darf sich der Zustand der Folge nicht
             * verändern. Deshalb darf die Methode mehrfach aufgerufen werden.
             */
            assertTrue(folge.hatNaechstes());
            assertTrue(folge.hatNaechstes());

            istElemente.add(folge.gibNaechstes());
        }

        assertEquals(Arrays.asList(sollElemente), istElemente);

        assertEquals(sollHatNaechsten, folge.hatNaechstes());
        assertEquals(sollHatNaechsten, folge.hatNaechstes());

        if (sollHatNaechsten) {
            folge.gibNaechstes();
        } else {
            assertThrows(NoSuchElementException.class,
                    () -> folge.gibNaechstes(),
                    "Es hätte eine NoSuchElementException geworfen werden müssen.");
        }
    }
}
