package katalog_lernen;

public class Katalog {

    private final int SCHRITTWEITE = 3;
    private final int INITIALGROESSE = 2;

    private int anzahl;

    private Katalogartikel[] katalogartikel;

    public Katalog(){
        katalogartikel = new Katalogartikel[INITIALGROESSE];
        anzahl = 0;
    }

    public void fuegeHinzu(Katalogartikel b){
        if(anzahl >= katalogartikel.length){
            this.vergroeßere();
        }
        katalogartikel[anzahl] = b;
        anzahl++;
    }

    public void vergroeßere() {
        Katalogartikel[] liste = new Katalogartikel[katalogartikel.length + SCHRITTWEITE];

        for(int i = 0; i < katalogartikel.length; i++){
            liste[i] = katalogartikel[i];
        }
        katalogartikel = liste;
    }

    public String gibListe(){
        String text = "";

        for(int i = 0; i < anzahl; i++){
            text = text + katalogartikel[i].gibText() + "\n";
        }

        return text;
    }

    public int gibAnzahlTreffer(String such){
        int treffer = 0;

        for(int i = 0; i < anzahl; i++){
            if(katalogartikel[i].passtZu(such)){
                treffer++;
            }
        }
        return treffer;
    }

    public Katalogartikel[] gibTreffer(String such){
        Katalogartikel[] treffer = new Katalogartikel[this.gibAnzahlTreffer(such)];
        int index = 0;

        for(int i = 0; i < anzahl; i++){
            if(katalogartikel[i].passtZu(such)){
                treffer[index] = katalogartikel[i];
                index++;
            }
        }
        return treffer;
    }

}
