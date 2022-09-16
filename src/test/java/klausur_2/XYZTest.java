package klausur_2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XYZTest {

    private XYZ xyz = new XYZ();

    @Test
    void testM(){
        List<String> soll = new LinkedList<>();
        soll.add("viel");
        soll.add("Erfolg");
        soll.add("Ich");
        soll.add("Ihnen");

        assertEquals(soll, xyz.m("jajaja"));
    }

}