package klausur_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Rechteck implements Comparable<Rechteck>{
    private int breite;
    private int hoehe;

    public Rechteck(int breite, int hoehe){
        this.breite = breite;
        this.hoehe = hoehe;
    }

    @Override
    public String toString(){
        return "(" + this.breite + " X " + this.hoehe + ")";
    }

    @Override
    public boolean equals(Object o){
        boolean gleich = false;
        if(o instanceof Rechteck){
            gleich = this.compareTo((Rechteck)o) == 0;
        }
        return gleich;
    }

    @Override
    public int compareTo(Rechteck r) {
        int vergleichswert = r.hoehe - this.hoehe;
        if(vergleichswert == 0){
            vergleichswert = this.breite - r.breite;
        }
        return vergleichswert;
    }

    public static void main(String[] args) {
        Rechteck r1 = new Rechteck(6,5);
        Rechteck r2 = new Rechteck(1,8);
        Rechteck r3 = new Rechteck(4,5);
        Rechteck r4 = new Rechteck(3,8);
        Rechteck r5 = new Rechteck(2,6);
        Rechteck r6 = new Rechteck(1,8);

        List<Rechteck> l = new ArrayList<>();

        l.add(r1);
        l.add(r2);
        l.add(r3);
        l.add(r4);
        l.add(r5);

        Collections.sort(l);

        System.out.println(l);

        TreeSet<Rechteck> t = new TreeSet<>();
        t.add(r1);
        t.add(r2);
        t.add(r3);
        t.add(r4);
        t.add(r5);
        t.add(r6);

        System.out.println(t);


    }
}
