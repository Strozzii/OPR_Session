package carsharing;

import java.util.ArrayList;
import java.util.Iterator;

public class Fahrzeug {

    private String name;
    private String ort;

    private ArrayList<Buchung> zeiten;


    public Fahrzeug(String name, String ort){
        this.name = name;
        this.ort = ort;

        zeiten = new ArrayList<>();

    }

    public String gibName(){
        return name;
    }

    public String gibStandort(){
        return ort;
    }

    public boolean istVerfuegbar(Buchung b){
        boolean istVerfuegbar = true;
        if(!zeiten.isEmpty()) {
            Iterator<Buchung> iter = zeiten.iterator();
            while(iter.hasNext() && istVerfuegbar) {
                istVerfuegbar = iter.next().pruefe(b);
            }
        }
        return istVerfuegbar;
    }


    public boolean buche(Buchung b){
        boolean istBuchbar = this.istVerfuegbar(b);
        if(istBuchbar){
            zeiten.add(b);
        }
        return istBuchbar;
    }



}
