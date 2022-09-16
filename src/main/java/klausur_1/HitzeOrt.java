package klausur_1;

import java.io.Reader;
import java.io.StringReader;

public class HitzeOrt implements Messwertverarbeiter{

    private int anzahl;
    private float schwellwert;
    private String ort;

    public HitzeOrt(float schwellwert, String ort){
        this.schwellwert = schwellwert;
        this.ort = ort;
        anzahl = 0;
    }

    public int gibAnzahl(){
        return anzahl;
    }

    @Override
    public void verarbeite(Messwert m) {
        if(this.ort == m.gibOrt() && this.schwellwert < m.gibTemperatur()){
            anzahl++;
        }
    }

    public static void main(String[] args) {
        Reader r = new StringReader("Bonn");
        Messwertverarbeiter hitzeort = new HitzeOrt(38, "Bonn");
        Messwerteleser leser = new Messwerteleser(r,hitzeort);
        //leser.lies();
        System.out.println("Hitze-Messwerte in Bonn: " + ((HitzeOrt) hitzeort).gibAnzahl());
    }
}
