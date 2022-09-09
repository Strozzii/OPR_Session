package katalog_lernen;

public class Buch extends Katalogartikel{

    private final int erscheinungsjahr;
    private final String autor;
    private final String titel;


    public Buch(String titel, String autor, float preis, int erscheinungsjahr){
        super(preis);

        this.titel = titel;
        this.autor = autor;
        this.erscheinungsjahr = erscheinungsjahr;
    }





    @Override
    public String gibText(){
        return (titel + "; " + autor + "; " + erscheinungsjahr + "; €" + getPreis());
    }

    @Override
    protected String gibSuchtext() {
        return (titel + " " + autor);
    }

}
