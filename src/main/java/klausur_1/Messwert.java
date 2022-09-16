package klausur_1;

public class Messwert {

    private String ort;
    private float temp;
    //private Datum date;

    public Messwert(String ort, float temp){
        this.ort = ort;
        this.temp = temp;
    }


    public String gibOrt(){
        return ort;
    }
    /**
    public Datum gibZeitpunkt(){

    }
    */
    public float gibTemperatur(){
        return temp;
    }

}
