package klausur_1;

public enum Einheit {
    MUM(1),
    MM(1 * 1000),
    CM(1 * 1000 * 10),
    DM(1 * 1000 * 10 * 10),
    M(1 * 1000 * 10 * 10 * 10),
    KM(1 * 1000 * 10 * 10 * 10 * 1000);

    Einheit(int mum){
        this.mum = mum;
    }

    private final int mum;

    //12000 * 10000 / 1 != 0 && 12000 * 10000 / 1 < 10000   MUM
    //12000 * 10000 / 1000 != 0 && 12000 * 10000 / 1000 < 10000    MM
    //12000 * 10000 / 10000 != 0 && 12000 * 10000 / 10000 < 10000     CM
    //12000 * 10000 / 100000 != 0 && 12000 * 10000 / 100000 < 10000     DM          letzteEinheit = DM
    //12000 * 10000 / 1000000 != 0 && 12000 * 10000 / 1000000 < 100000    M         letzteEinheit = M
    //12000 * 10000 / 1000000000 != 0 && 12000 * 10000 / 1000000000 < 1000000   KM


    Einheit geeigneteEinheit(long z){
        Einheit[] einheiten =  Einheit.values();
        Einheit letzteEinheit = this;
        for(Einheit a : einheiten) {
            if(z  * this.mum / a.mum != 0 && z * this.mum / a.mum < letzteEinheit.mum) {
                letzteEinheit = a;
            }
        }
        return letzteEinheit;
    }

    public static void main(String[] args) {
        System.out.println(CM.geeigneteEinheit(12000));
        System.out.println(MM.geeigneteEinheit(2_000_000));
    }
}
