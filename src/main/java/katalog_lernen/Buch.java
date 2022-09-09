package katalog_lernen;

public class Buch extends Katalogartikel implements Comparable<Buch>{

    private final int erscheinungsjahr;
    private final String autor;
    private final String titel;


    public Buch(String titel, String autor, float preis, int erscheinungsjahr){
        super(preis);

        this.titel = titel;
        this.autor = autor;
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public String gibAutor(){
        return autor;
    }

    @Override
    public String gibText(){
        return (titel + "; " + autor + "; " + erscheinungsjahr + "; €" + getPreis());
    }

    @Override
    protected String gibSuchtext() {
        return (titel + " " + autor);
    }



    @Override
    public boolean equals(Object obj){
        boolean istGleich = false;
        if(obj instanceof Buch b){
            istGleich = titel.equals(b.titel) && autor.equals(b.autor) && erscheinungsjahr == b.erscheinungsjahr;
        }
        return istGleich;
    }

    @Override
    public int hashCode(){
        return titel.hashCode() + autor.hashCode() + erscheinungsjahr;
    }

    @Override
    public String toString(){
        return titel + " (" + getPreis() + ")";
    }

    @Override
    public int compareTo(Buch o) {
        int vergleichswert = autor.compareTo(o.autor);
        if(vergleichswert == 0){
            vergleichswert = titel.compareTo(o.titel);
            if(vergleichswert == 0){
                vergleichswert = this.erscheinungsjahr - o.erscheinungsjahr;
            }
        }
        return vergleichswert;

    }
}
