package textverarbeitung;

import java.util.StringTokenizer;

public class Textverarbeiter {

    private Wortverarbeiter verarbeiter;

    public Textverarbeiter(Wortverarbeiter verarbeiter){
        this.verarbeiter = verarbeiter;
    }

    public void verarbeite(String s){

        String zeile;
        StringTokenizer st = new StringTokenizer(s, "\n", true);
        while(st.hasMoreTokens()){
            zeile = st.nextToken();

            if(zeile.equals("\n")){
                verarbeiter.verarbeiteZeilenende();
            } else {
                StringTokenizer woerter = new StringTokenizer(zeile, " ,.;:!?()-");

                while(woerter.hasMoreTokens()){
                    verarbeiter.verarbeite(woerter.nextToken());
                }
            }
        }

    }

}
