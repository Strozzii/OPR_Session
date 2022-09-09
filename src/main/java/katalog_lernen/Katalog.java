package katalog_lernen;

import java.util.ArrayList;
import java.util.Iterator;

public class Katalog {

    private final ArrayList<Katalogartikel> katalogartikel;

    public Katalog(){
        katalogartikel = new ArrayList<>();
    }

    public void fuegeHinzu(Katalogartikel b){
        katalogartikel.add(b);
    }


    public String gibListe(){
        String darstellung = "";

        for(Katalogartikel artikel : katalogartikel){
            darstellung = darstellung + artikel.gibText() + "\n";
        }

        return darstellung;
    }

    // Iteration per Index
    public ArrayList<Katalogartikel> gibTreffer1(String such){
        ArrayList<Katalogartikel> trefferliste = new ArrayList<>();

        for(int i = 0; i < katalogartikel.size(); i++){
            Katalogartikel artikel = katalogartikel.get(i);
            if(artikel.passtZu(such)){
                trefferliste.add(artikel);
            }
        }

        return trefferliste;
    }

    //Iteration per Iterator
    public ArrayList<Katalogartikel> gibTreffer2(String such){
        ArrayList<Katalogartikel> trefferliste = new ArrayList<>();

        Iterator<Katalogartikel> iter = katalogartikel.iterator();

        while(iter.hasNext()){
            Katalogartikel artikel = iter.next();
            if(artikel.passtZu(such)){
                trefferliste.add(artikel);
            }
        }

        return trefferliste;
    }

    //Iteration mit erweiterter for-Schleife
    public ArrayList<Katalogartikel> gibTreffer3(String such){
        ArrayList<Katalogartikel> trefferliste = new ArrayList<>();

        for(Katalogartikel artikel : katalogartikel){
            if(artikel.passtZu(such)){
                trefferliste.add(artikel);
            }
        }

        return trefferliste;
    }


}
