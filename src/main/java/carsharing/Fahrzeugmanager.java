package carsharing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Fahrzeugmanager {

    private HashMap<String, Fahrzeug> fahrzeuge;

    public Fahrzeugmanager(){
        fahrzeuge = new HashMap<>();
    }

    public void fuegeFahrzeugHinzu(String name, String ort){
        if(!fahrzeuge.containsKey(name)){
            fahrzeuge.put(name, new Fahrzeug(name, ort));
        }
    }

    public ArrayList<String> gibFahrzeugnamen(){
        ArrayList<String> namen = new ArrayList<>(fahrzeuge.keySet());
        Collections.sort(namen);
        return namen;
    }

    public ArrayList<String> gibFahrzeugnamen(String ort){
        ArrayList<String> namen = new ArrayList<>();
        Iterator<Fahrzeug> iter = fahrzeuge.values().iterator();
        while(iter.hasNext()){
            Fahrzeug fahrzeug = iter.next();
            if(fahrzeug.gibStandort().equals(ort)){
                namen.add(fahrzeug.gibName());
            }
            Collections.sort(namen);
        }

        return namen;
    }

    public boolean bucheFahrzeug(String name, String anfang, String ende){

        return fahrzeuge.get(name).buche(new Buchung(anfang, ende));

    }

    public ArrayList<String> gibVerfuegbareFahrzeuge(String ort, String anfang, String ende){
        ArrayList<String> output = new ArrayList<>();
        Iterator<Fahrzeug> iter = fahrzeuge.values().iterator();

        while(iter.hasNext()){
            Fahrzeug f = iter.next();
            if(f.gibStandort().equals(ort) && f.istVerfuegbar(new Buchung(anfang, ende))){
                output.add(f.gibName());
            }
        }
        Collections.sort(output);

        return output;
    }




}
