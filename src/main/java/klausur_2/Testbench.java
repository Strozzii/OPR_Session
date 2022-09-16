package klausur_2;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.*;

public class Testbench {
    public static void main(String[] args) {
        OutputStream os = new ByteArrayOutputStream();

        //long v = 12.5f;

        Float f = 12.5f;

        Object o = "Java".substring(3);

        //BufferedReader b = new LineNumberReader(os);

        //HashSet<String> h = new HashMap<String, Integer>().keySet();

        List<String> l = new LinkedList<String>();

        Comparator<String> c = (s, t) -> s.length() - t.length();

    }
}
