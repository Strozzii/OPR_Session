package klausur_3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Listenfilter {

    public static List<String> filter(List<String> elemente, char anfang){
        ArrayList<String> gefilterteElemente = new ArrayList<>();
        for(String element : elemente){
            if(!element.isEmpty() && element.charAt(0) == anfang){
                gefilterteElemente.add(element);
            }
        }
        return gefilterteElemente;
    }

    public static List<String> filter(List<String> elemente, Filterkriterium f){
        return elemente.stream()
                .filter(t -> f.laesstDurch(t))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> woerter = new ArrayList<>();
        woerter.add("Hallo");
        woerter.add("Hallo, wie gehts?");
        woerter.add("gut und selbst?");
        woerter.add("auch");
        System.out.println(filter(woerter, new FilterA()));
    }



}
