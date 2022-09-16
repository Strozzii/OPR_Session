package klausur_3;

public class Zeitdauer {

    private int h;
    private int m;

    public Zeitdauer(int h, int m){
        if(h < 0 || m < 0){
            throw new IllegalArgumentException("Parameter müssen größergleich 0 sein");
        }
        this.h = h;
        this.m = m;
    }

    @Override
    public boolean equals(Object dauer){
        boolean gleich = false;
        if(dauer instanceof Zeitdauer){
            gleich = (this.h + this.m / 60) == (((Zeitdauer) dauer).h + ((Zeitdauer) dauer).m / 60)
                    && (this.m % 60) == (((Zeitdauer) dauer).m % 60);
        }
        return gleich;
    }

    @Override
    public int hashCode(){
        return (h * 60) + (m % 60);
    }

    public static void main(String[] args) {
        Zeitdauer z1 = new Zeitdauer(1,100);
        Zeitdauer z2 = new Zeitdauer(2,40);

        System.out.println(z1.equals(z2));
    }

}
