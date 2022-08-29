package zahlenfolge;

import java.util.NoSuchElementException;

public class FibonacciFolge implements Zahlenfolge{

    private int f0;
    private int f1;

    public FibonacciFolge(){
        f0 = 0;
        f1 = 1;
    }


    @Override
    public boolean hatNaechstes() {
        return true;
    }

    @Override
    public int gibNaechstes() throws NoSuchElementException {
        int output = f0;
        f0 = f1;
        f1 = f1 + output;
        return output;
    }
}
