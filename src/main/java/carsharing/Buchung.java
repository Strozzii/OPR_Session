package carsharing;

public class Buchung {

    private String anfang;
    private String ende;

    public Buchung(String anfang, String ende){
        this.anfang = anfang;
        this.ende = ende;
    }

    public boolean pruefe(Buchung b){
        return (this.anfang.compareTo(b.ende) >=0) || (this.ende.compareTo(b.anfang) <= 0);
    }

    public boolean equals(Buchung b){
        return this.anfang.equals(b.anfang) && this.ende.equals(b.ende);
    }

    public int hashCode(){
        return this.anfang.hashCode() + this.ende.hashCode();
    }


}
