package klausur_3;

import java.util.*;

public class ErzeugeIndex {

    public static Map<Character, Collection<String>> erzeugeIndex(String[] woerter){
        HashMap<Character, Collection<String>> hm = new HashMap<>();

        for(String s : woerter){
            char c = s.charAt(0);
            if(hm.containsKey(c)){
                hm.get(c).add(s);
            } else {
                TreeSet<String> liste = new TreeSet<>();
                liste.add(s);
                hm.put(c,liste);
            }
        }
        return hm;

    }

    public static void main(String[] args) {
        String[] w = new String[]{"Fahrrad", "123 Abflussreinigung", "Fahrstuhl", "frische Blumen", "Fahrrad", "Pfirsich"};
        System.out.println(erzeugeIndex(w));
    }
}
