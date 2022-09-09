package katalog_lernen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ZeigeCompare {

    public static void gibAus(List<? extends Object> liste){
        for(Object o : liste){
            System.out.println(o);
        }
    }

    private static List<Buch> erzeugeBuecherliste(){
        ArrayList<Buch> buecher = new ArrayList<>();

        buecher.add(new Buch("Tränen zum Abschied", "Billi Groman", 2.55f, 2004));
        buecher.add(new Buch("Der Bergdoktor am Abgrund der Liebe", "B. Lödsinn", 2.95f, 2004));
        buecher.add(new Buch("Ein Abschied mit Tränen", "Billi Groman", 2.65f, 2004));
        buecher.add(new Buch("Tränen im Knopfloch", "Helge Schneider", 12.85f, 2004));

        return buecher;
    }

    private static void testBuecherAlphabetisch(){
        List<Buch> buecher = erzeugeBuecherliste();
        Collections.sort(buecher);
        gibAus(buecher);
    }

    public static void testBuecherNachPreis() {
        List<Buch> buecher = erzeugeBuecherliste();

        Collections.sort(buecher, new Preisvergleicher());
        gibAus(buecher);
    }

    public static void testBuecherNachAutorUndPreis(){
        List<Buch> buecher = erzeugeBuecherliste();

        Comparator<Buch> vergleicher = (buch1, buch2) -> {
            int vergleichswert = buch1.gibAutor().compareTo(buch2.gibAutor());
            if(vergleichswert == 0){
                vergleichswert = (int) Math.signum(buch1.getPreis() - buch2.getPreis());
            }
            return vergleichswert;
        };

        Collections.sort(buecher, vergleicher);
        gibAus(buecher);
    }

    public static void testBuecherNachPreisAbsteigend(){
        List<Buch> buecher = erzeugeBuecherliste();

        Collections.sort(buecher, (Buch buch1, Buch buch2) -> (int) Math.signum(buch2.getPreis() - buch1.getPreis()));
        gibAus(buecher);

    }

    public static void main(String[] args) {
        //testBuecherAlphabetisch();
        //testBuecherNachPreis();
        //testBuecherNachAutorUndPreis();
        testBuecherNachPreisAbsteigend();
    }



}
