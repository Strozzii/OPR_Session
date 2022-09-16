/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package textverarbeitung;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexiererTest {
    private String text;
    private ArrayList<String> ausschlusswoerter;
    
    @BeforeEach
    public void setUp() {
        this.text = "Ich lebe in einem Haus,\n in einem Haus am See";
        ausschlusswoerter = new ArrayList<>();
        ausschlusswoerter.add("Haus");
        

    }
    
    @Test
    public void testGibZeilennummern() {
        Indexierer test = new Indexierer(ausschlusswoerter);
        
        StringTokenizer woerter = new StringTokenizer(text, ".,:;!?-() ");
        while(woerter.hasMoreTokens()) {
            String wort = woerter.nextToken();
            test.verarbeite(wort);
        }
        
        assertEquals("1, 2", test.gibZeilenNummern("einem"));
    }
    
    @Test
    public void testGibWoerter() {
        Indexierer test = new Indexierer(ausschlusswoerter);
        test.verarbeite(text);
        List<String> woerter = new ArrayList<>();
        
        woerter.add("Ich");
        woerter.add("lebe");
        woerter.add("in");
        woerter.add("einem");
        woerter.add("am");
        woerter.add("See");
        Collections.sort(woerter);
        
        assertEquals(woerter, test.gibWoerter());
    }
            
    @Test
    public void testGibWoerter2() {
        Indexierer test = new Indexierer(ausschlusswoerter);
        
        StringTokenizer woerter = new StringTokenizer(text, ".,:;!?-() ");
        while(woerter.hasMoreTokens()) {
            String wort = woerter.nextToken();
            test.verarbeite(wort);
        }
        
        List<String> soll = new ArrayList<>();
        
        soll.add("Ich");
        soll.add("lebe");
        soll.add("in");
        soll.add("einem");
        soll.add("am");
        soll.add("See");
        Collections.sort(soll);
        
        assertEquals(soll, test.gibWoerter());
    }
    
}
