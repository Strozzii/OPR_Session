package zahlenfolge;

import java.util.NoSuchElementException;

public interface Zahlenfolge {

    boolean hatNaechstes();

    int gibNaechstes() throws NoSuchElementException;

}
