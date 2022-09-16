package textverarbeitung;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Textverarbeiter {
    private Wortverarbeiter warbeiter;
    private ArrayList<String> woerter = new ArrayList<>();

    private List<List> zeilen = new ArrayList<>();

    public Textverarbeiter(Wortverarbeiter warbeiter) {
        this.warbeiter = warbeiter;
    }

//    public void verarbeite2(String text) {
//        ArrayList<String> woerter = new ArrayList<>();
//
//        StringTokenizer tokens = new StringTokenizer(text, ".,:;!?-() ");
//
//        while(tokens.hasMoreTokens()) {
//            woerter.add(tokens.nextToken());
//        }
//
//        this.woerter = woerter;
//    }

    public void verarbeite(String text) {
        StringTokenizer woerter = new StringTokenizer(text, ".,:;!?-() ");
        while(woerter.hasMoreTokens()) {
            String wort = woerter.nextToken();
            warbeiter.verarbeite(wort);
        }

//        warbeiter.verarbeite(text);
    }
}