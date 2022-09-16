package klausur_2;

import org.junit.Before;

import java.io.Reader;
import java.io.StringReader;

class SindGleichTest {

    private Reader r1;
    private Reader r2;

    @Before
    public void setUp() {

        r1 = new StringReader("1234567890");
        r2 = new StringReader("123456783234245");

    }

}