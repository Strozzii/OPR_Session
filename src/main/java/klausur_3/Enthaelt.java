package klausur_3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Enthaelt {

    public static boolean enthaelt(InputStream is, Set<Byte> bytes) throws IOException {
        byte[] puffer = new byte[8];
        int count = is.read(puffer);
        int zahl = 0;
        for(Byte b : bytes){
            for(int i = 0; i < count; i++){
                if(puffer[i] == b){
                    zahl++;
                }
            }
        }


        return zahl >= bytes.size();
    }

    public static void main(String[] args) throws IOException {
        byte[] a = new byte[] {1,2,5,5,1,2,5,5,1,2,5,5,1,2,5,5,1,2,5,5,1,2,5,5};
        InputStream is = new ByteArrayInputStream(a);
        Set<Byte> set = new HashSet<>();
        set.add((byte) 1);
        set.add((byte) 2);
        set.add((byte) 8);

        System.out.println(enthaelt(is, set));
    }
}
