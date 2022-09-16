package klausur_2;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class SindGleich {

    public static boolean sindGleich(Reader r1, Reader r2, short n) throws IOException {
        boolean gleich = true;

        char param1[] = new char[n];
        char param2[] = new char[n];
        int counter1 = r1.read(param1);
        int counter2 = r2.read(param2);
        int zaehler = Math.min(Math.min(counter1,counter2), n);

        for(int i = 0; i < zaehler && gleich; i++){
            System.out.println(param1[i] + " " + param2[i]);
            gleich = param1[i] == param2[i];
        }
        return gleich;

    }

    public static void main(String[] args) throws IOException {
        Reader r1 = new StringReader("1234567890");
        Reader r2 = new StringReader("123456783234245");
        System.out.println(sindGleich(r1, r2, (short) 9));

    }

}
