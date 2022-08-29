package zahlenfolge;

import java.util.NoSuchElementException;

public class Mischfolge implements Zahlenfolge{

    private PushBackFolge p1;
    private PushBackFolge p2;

    public Mischfolge(Zahlenfolge nums1, Zahlenfolge nums2){
        this.p1 = new PushBackFolge(nums1);
        this.p2 = new PushBackFolge(nums2);
    }

    @Override
    public boolean hatNaechstes() {
        return (p1.hatNaechstes() || p2.hatNaechstes());
    }

    @Override
    public int gibNaechstes() throws NoSuchElementException {
        int output;

        if(p1.hatNaechstes() && p2.hatNaechstes()){
            int z1 = p1.gibNaechstes();
            int z2 = p2.gibNaechstes();

            if(z1 < z2){
                output = z1;
                p2.schreibeZurueck(z2);
            } else {
                output = z2;
                p1.schreibeZurueck(z1);
            }

        } else if(p1.hatNaechstes()){
            output = p1.gibNaechstes();
        } else if(p2.hatNaechstes()){
            output = p2.gibNaechstes();
        } else {
            throw new NoSuchElementException("Naechstes Element nicht gefunden!");
        }

        return output;
    }
}

















