package katalog_lernen;

import java.util.ArrayList;
import java.util.List;

public class Bundle implements Verkaufbares{

    private static float ABSCHLAGSFAKTOR = 0.95f;
    private final String beschreibung;
    private final List<Verkaufbares> einzelartikel;

    public Bundle(String beschreibung){
        this.beschreibung = beschreibung;
        einzelartikel = new ArrayList<>();
    }

    @Override
    public boolean passtZu(String suchbegriff) {
        boolean passt = beschreibung.contains(suchbegriff);

        int i = 0;
        while(i < einzelartikel.size() && !passt){
            passt = einzelartikel.get(i).passtZu(suchbegriff);
            i = i + 1;
        }

        return passt;
    }

    @Override
    public String gibText() {
        return beschreibung + ": enthält " + einzelartikel.size() + " Artikel";
    }

    @Override
    public float getPreis() {
        float gesamtpreis = 0;

        for(Verkaufbares artikel : einzelartikel){
            gesamtpreis = gesamtpreis + artikel.getPreis();
        }
        return gesamtpreis * ABSCHLAGSFAKTOR;
    }

    public void fuegeHinzu(Verkaufbares artikel){
        einzelartikel.add(artikel);
    }
}
