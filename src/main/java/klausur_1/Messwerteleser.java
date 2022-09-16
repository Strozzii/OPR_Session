package klausur_1;

import java.io.Reader;

public class Messwerteleser {

    private Reader r;
    private Messwertverarbeiter m;

    public Messwerteleser(Reader r, Messwertverarbeiter m){
        this.r = r;
        this.m = m;
    }

    /**

    public void lies(){
        while(this.gibtEsWeiterenMesswert()){
            Messwert wert = this.gibNaechstenMesswert();


        }
    }
    */
}
