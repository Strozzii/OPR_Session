package klausur_1;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashSet;

public class MinLaengeUndZeichen {

    public static boolean minLaengeUndZeichen(Reader r, short l, short n) throws IOException {
        boolean gueltig;

        HashSet<Character> buchstaben = new HashSet<>();

        char[] buffer = new char[l];
        int reader = r.read(buffer);

        for(int i = 0; i < l; i++){
            buchstaben.add(buffer[i]);
            System.out.println(buchstaben);
        }

        gueltig = buchstaben.size() >= n;

        return gueltig;
    }

    public static void main(String[] args) throws IOException {
        Reader r = new StringReader("abababacbc");
        System.out.println(minLaengeUndZeichen(r, (short) 8, (short) 3));
    }

}
