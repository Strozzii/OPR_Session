package katalog_lernen;

public class Katalog {

    private final int SCHRITTWEITE = 3;
    private final int INITIALGROESSE = 2;

    private int index;

    private Buch[] buecher;

    public Katalog(){
        buecher = new Buch[INITIALGROESSE];
        index = 0;
    }

    public void fuegeHinzu(Buch b){
        if(index >= buecher.length){
            this.vergroeßere();
        }
        buecher[index] = b;
    }

    public void vergroeßere() {
        Buch[] neu = new Buch[buecher.length + SCHRITTWEITE];
        buecher = neu;
    }

    public void gibBuecher throws NullPointerException(){
        try(NullPointerException n){

        }

    }

}
