package katalog_lernen;

public class Buch {

    private String titel;
    private String autor;
    private float preis;
    private int erscheinungsjahr;


    public Buch(String titel, String autor, float preis, int erscheinungsjahr){
        this.titel = titel;
        this.autor = autor;
        this.preis = preis;
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public String gibText(){
        return titel + "; " + autor + "; " + erscheinungsjahr + "; €" + preis;
    }

}
