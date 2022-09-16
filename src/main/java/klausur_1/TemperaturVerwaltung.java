package klausur_1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class TemperaturVerwaltung {

    private final LinkedList<Temperatur> temperaturen;
    private final HashSet<Temperatur> temperaturs;

    public TemperaturVerwaltung(){
        temperaturen = new LinkedList<>();
        temperaturs = new HashSet<>();
    }

    public int fuegeHinzuNeu(Temperatur t){
        temperaturs.add(t);

        return temperaturs.size();
    }

    public int fuegeHinzu(Temperatur t){
        Iterator<Temperatur> ts = temperaturen.iterator();
        boolean schonEnthalten = false;

        while (ts.hasNext() && !schonEnthalten) {
            schonEnthalten = ts.next().wert() == t.wert();
        }

        if (!schonEnthalten) {
            temperaturen.add(t);
        }

        return temperaturen.size();

    }



}
