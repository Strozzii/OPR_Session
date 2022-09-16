package klausur_1;

import org.junit.Before;

import java.io.Reader;
import java.io.StringReader;

class MinLaengeUndZeichenTest {

    private Reader r;

    @Before
    public void setUp(){
        r = new StringReader("ababababc");
    }

}