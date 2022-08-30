package textverarbeitung;

import java.util.*;

public class Indexierer implements Wortverarbeiter{

    private int zeile;
    private HashSet<String> ausschlusswoerter;
    private HashMap<String, String> woerter;

    public Indexierer(Collection<String> c){
        zeile = 1;
        ausschlusswoerter = new HashSet<>();
        woerter = new HashMap<>();
    }

    public List<String> gibWoerter(){
        ArrayList<String> output = new ArrayList<>();
        Iterator<String> iter = woerter.keySet().iterator();

        while(iter.hasNext()){
            output.add(iter.next());
        }
        Collections.sort(output);
        return output;
    }

    public String gibZeilennummern(String s){
        String output = "";

        if(woerter.containsKey(s)){
            output = woerter.get(s);
        }
        return output;
    }

    @Override
    public void verarbeite(String s) {
        if(!ausschlusswoerter.contains(s)) {
            if(woerter.containsKey(s)) {
                woerter.put(s, woerter.get(s) + ", " + zeile);
            } else {
                woerter.put(s, "" + zeile);
            }
        }
    }

    @Override
    public void verarbeiteZeilenende() {
        zeile++;
    }
}
