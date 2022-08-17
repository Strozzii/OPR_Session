package personal;

public class Mitarbeiter {

    protected String name;
    protected static int limit_allgemein = 20;
    protected Vorgesetzter chef = null;

    public Mitarbeiter(String name){
        this.name = name;
    }

    public static void setzeAllgemeinesLimit(int limit){
        limit_allgemein = limit;
    }

    public void setzeVorgesetzten(Vorgesetzter chef){
        this.chef = chef;
    }

    public boolean darfBestellen(int wert){
        return wert <= limit_allgemein;
    }

    public String gibLevel(){
        return this.chef == null ? "freier Mitarbeiter"
                                 : "Mitarbeiter";
    }

    public String gibName(){
        return this.name;
    }

    public String gibVorgesetzter(){
        return chef.name;
    }

    public int gibLimit(){
        return limit_allgemein;
    }



    public String gibInfo(){

        String chef_info = this.chef == null ? ""
                                             : "Mein Vorgesetzter ist " + this.gibVorgesetzter() + ". ";

        return "Ich bin " + this.gibLevel() + ", Name " + this.gibName() + ". " + chef_info + "Mein Bestelllimit ist "
                + this.gibLimit() + " EUR.";
    }

    public String gibHierarchie(){
        String hierarchie = this.gibLevel() + " " + this.gibName();
        Vorgesetzter k = this.chef;

        while(k != null){
            hierarchie = k.gibLevel() + " " + k.gibName() + "\n" + hierarchie;
            k = k.chef;
        }

        return hierarchie;
    }
}
