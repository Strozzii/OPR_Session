package klausur_1;

public class Temperatur {

    private final float t;

    public Temperatur(float t){
        if(t < -273.15f){
            throw new IllegalArgumentException("Es existieren keine Temperaturen unterhalb des Nullpunkts");
        }
        this.t = t;
    }

    public float wert(){
        return t;
    }

}
