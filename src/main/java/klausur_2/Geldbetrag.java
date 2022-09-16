package klausur_2;

import java.util.*;

public class Geldbetrag{

    private String waehrung;
    private double betrag;

    public Geldbetrag(String waehrung, double betrag){

        if(waehrung.length() > 3){
            throw new IllegalArgumentException(waehrung + " ist kein zulässiges Währungskürzel!");
        }

        this.waehrung = waehrung;
        this.betrag = betrag;
    }

    public static Map<String, Double> summiere(Collection<Geldbetrag> betraege){
        Map<String, Double> liste = new TreeMap<>();


        for(Geldbetrag g : betraege){
            if(liste.containsKey(g.waehrung)){
                liste.put(g.waehrung, liste.get(g.waehrung) + g.betrag);
            } else {
                liste.put(g.waehrung, g.betrag);
            }
        }

        System.out.println(liste);

        return liste;
    }

    @Override
    public boolean equals(Object g){
        boolean equal = false;
        if(g instanceof Geldbetrag){
            equal = this.waehrung.equals(((Geldbetrag) g).waehrung) && this.betrag == ((Geldbetrag) g).betrag;
        }
        return equal;
    }

    @Override
    public int hashCode(){
        return this.waehrung.hashCode() + (int)(this.betrag * 100);
    }

    public static void main(String[] args) {
        Collection<Geldbetrag> test = new ArrayList<>();
        test.add(new Geldbetrag("EUR", 30));
        test.add(new Geldbetrag("EUR", 12));
        test.add(new Geldbetrag("EUR", 8));
        test.add(new Geldbetrag("CHF", 30));
        test.add(new Geldbetrag("CHF", 12));
        test.add(new Geldbetrag("USD", 12));

        summiere(test);
    }

}
