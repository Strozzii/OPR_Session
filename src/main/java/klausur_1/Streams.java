package klausur_1;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

public class Streams {
    public static void main(String[] args) {
        Reader r = new BufferedReader(new StringReader("@Erdbeertörtchen 123 aHa   "));
        System.out.println(((BufferedReader) r).lines()
                .filter(s -> s.startsWith("@"))
                .map(s -> s.stripTrailing())
                .anyMatch(s -> s.toLowerCase().endsWith("aha")));
    }
}
