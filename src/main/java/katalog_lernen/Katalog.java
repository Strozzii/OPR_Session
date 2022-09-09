package katalog_lernen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Katalog {

    private final List<Verkaufbares> katalogartikel;

    public Katalog(){
        katalogartikel = new ArrayList<>();
    }

    public void fuegeHinzu(Verkaufbares b){
        katalogartikel.add(b);
    }

    public String gibStreamListe(){
        return katalogartikel.stream()
                .map(artikel -> artikel.gibText())
                .reduce("", (gesamttext, text) -> gesamttext + text + "\n");
    }

    public String gibListe(){
        String darstellung = "";

        for(Verkaufbares artikel : katalogartikel){
            darstellung = darstellung + artikel.gibText() + "\n";
        }

        return darstellung;
    }

    // Streams
    public List<Verkaufbares> gibTreffer(String suchbegriff){
       return katalogartikel.stream()
               .filter(artikel -> artikel.passtZu(suchbegriff))
               .collect(Collectors.toList());
    }

    // Iteration per Index
    public List<Verkaufbares> gibTreffer1(String such){
        ArrayList<Verkaufbares> trefferliste = new ArrayList<>();

        for(int i = 0; i < katalogartikel.size(); i++){
            Verkaufbares artikel = katalogartikel.get(i);
            if(artikel.passtZu(such)){
                trefferliste.add(artikel);
            }
        }

        return trefferliste;
    }

    //Iteration per Iterator
    public List<Verkaufbares> gibTreffer2(String such){
        ArrayList<Verkaufbares> trefferliste = new ArrayList<>();

        Iterator<Verkaufbares> iter = katalogartikel.iterator();

        while(iter.hasNext()){
            Verkaufbares artikel = iter.next();
            if(artikel.passtZu(such)){
                trefferliste.add(artikel);
            }
        }

        return trefferliste;
    }

    //Iteration mit erweiterter for-Schleife
    public List<Verkaufbares> gibTreffer3(String such){
        ArrayList<Verkaufbares> trefferliste = new ArrayList<>();

        for(Verkaufbares artikel : katalogartikel){
            if(artikel.passtZu(such)){
                trefferliste.add(artikel);
            }
        }

        return trefferliste;
    }


}
