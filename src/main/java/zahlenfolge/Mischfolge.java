package zahlenfolge;

import java.util.NoSuchElementException;

public class Mischfolge implements Zahlenfolge{
    @Override
    public boolean hatNaechstes() {
        return false;
    }

    @Override
    public int gibNaechstes() throws NoSuchElementException {
        return 0;
    }
}
