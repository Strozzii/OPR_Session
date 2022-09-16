package textverarbeitung;

import java.util.*;

public class Indexierer implements Wortverarbeiter{
    private Collection<String> ausschlusswoerter;
    private List<String> woerter = new ArrayList<>();
    private HashMap<String, List> indizes = new HashMap<>();
    private int anzahlZeilen;

    public Indexierer(Collection<String> ausschlusswoerter) {
        this.ausschlusswoerter = ausschlusswoerter;
        this.anzahlZeilen = 1;
    }

    public List<String> gibWoerter() {
        Collections.sort(woerter);

        return woerter;
    }

    public String gibZeilenNummern(String wort) {
        String zeilen = "";

        if(indizes.containsKey(wort)) {
            Iterator iter = indizes.get(wort).iterator();

            while(iter.hasNext()) {
                zeilen = zeilen + iter.next() + ", ";
            }
            zeilen = zeilen.substring(0, zeilen.length() - 2);
        }

        return zeilen;
    }

    public void woerter(String wort) {
        if(!ausschlusswoerter.contains(wort) && !woerter.contains(wort)) {
            woerter.add(wort);
        }
    }

    public void index(String wort) {
        if(!ausschlusswoerter.contains(wort)) {
            if(indizes.containsKey(wort)) {
                List<Integer> nummern = indizes.get(wort);
                nummern.add(anzahlZeilen);
                indizes.put(wort, nummern);
            }
            else {
                List<Integer> nummern = new ArrayList();
                nummern.add(anzahlZeilen);
                indizes.put(wort, nummern);
            }
        }
    }

    @Override
    public void verarbeite(String wort) {
        if(wort.equals("\n")) {
            verarbeiteZeilenende();
        }
        else {
            woerter(wort);
            index(wort);
        }
    }

    @Override
    public void verarbeiteZeilenende() {
        this.anzahlZeilen = this.anzahlZeilen + 1;
    }
}