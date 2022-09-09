package katalog_lernen;

public class Auto extends Motorfahrzeug implements Verkaufbares {

    private final float preis;

    public Auto(String bezeichnung, int leistung, int baujahr, float preis){
        super(bezeichnung, leistung, baujahr);
        this.preis = preis;
    }

    @Override
    public boolean passtZu(String suchbegriff) {
        return this.bezeichnung.contains(suchbegriff);
    }

    @Override
    public String gibText() {
        return this.bezeichnung + ", " + this.leistung + "kW, Baujahr " + this.baujahr + ", " + this.preis + "€";
    }

    @Override
    public float getPreis() {
        return preis;
    }
}
