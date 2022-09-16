package klausur_2;

public abstract class Zeichenobjekt2D {

    public String gibInfo(){
        return this.getArt() + "\nBreite: " + this.getBreite() + "\nHöhe: " + this.getHoehe();
    }

    protected abstract String getHoehe();

    protected abstract String getBreite();

    protected abstract String getArt();

}
