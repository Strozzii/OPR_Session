package lernsession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class IO {

    public static void test1() throws IOException {
        Reader r = new BufferedReader(new StringReader("Hallo.\nIch bin der Tom\nund bin richtig doof"));

        char[] buffer = new char[10];
        int anzahl = r.read(buffer);

        for(int i = 0; i < anzahl; i++){
            System.out.print(buffer[i]);
        }


    }

    public static void main(String[] args) throws IOException {
        test1();
    }
}
