package zahlenfolge;

import java.util.NoSuchElementException;

public class PushBackFolge implements Zahlenfolge{
    @Override
    public boolean hatNaechstes() {
        return false;
    }

    @Override
    public int gibNaechstes() throws NoSuchElementException {
        return 0;
    }
}
