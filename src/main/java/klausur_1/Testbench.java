package klausur_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Testbench {

    private TreeMap<String, ArrayList<Integer>> hm = new TreeMap<>();

    public void fuegeHinzu(String schluessel, int zahl){
        ArrayList<Integer> l = hm.get(schluessel);
        if(l != null) {
            l.add(zahl);
            hm.put(schluessel, l);
        }
    }


    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.m(10));

        Set<String> set = new HashSet<>();
    }
}
