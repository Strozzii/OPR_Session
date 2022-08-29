package zahlenfolge;

import java.util.NoSuchElementException;

public class EindeutigeFolge implements Zahlenfolge{
    @Override
    public boolean hatNaechstes() {
        return false;
    }

    @Override
    public int gibNaechstes() throws NoSuchElementException {
        return 0;
    }
}
