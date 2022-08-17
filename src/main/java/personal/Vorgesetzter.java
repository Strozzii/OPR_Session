package personal;

public class Vorgesetzter extends Mitarbeiter {

    private int limit = 0;

    public Vorgesetzter(String name){
        super(name);
    }

    public void setzeBestelllimit(int limit){
        this.limit = limit;
    }

    @Override
    public boolean darfBestellen(int wert) {
        return this.limit == 0 ? wert <= limit_allgemein
                               : wert <= limit;
    }

    @Override
    public String gibLevel(){
        return "Vorgesetzter";
    }

    @Override
    public int gibLimit() {
        return this.limit == 0 ? limit_allgemein
                : limit;
    }
}
