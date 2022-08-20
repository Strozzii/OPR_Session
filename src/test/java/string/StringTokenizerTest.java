package string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.*;

public class StringTokenizerTest {

    private String string;
    private String trenner;
    private StringTokenizer st;

    @BeforeEach
    void setUp(){
        string = "--abc +-xyz";
        trenner = "+-";
        st = new StringTokenizer(string, trenner);
    }

    @Test
    void testNextToken1(){
        assertEquals("abc ", st.nextToken());
    }

    @Test
    void testNextToken2(){
        assertEquals("abc ", st.nextToken());
        assertEquals("xyz", st.nextToken());
    }

    @Test
    void testNextToken3(){
        assertEquals("abc ", st.nextToken());
        assertEquals("xyz", st.nextToken());
        assertThrows(NoSuchElementException.class, () -> st.nextToken());
    }

    @Test
    void testHasMoreTokens(){
        assertTrue(st.hasMoreTokens());
        st.nextToken();
        assertTrue(st.hasMoreTokens());
        st.nextToken();
        assertFalse(st.hasMoreTokens());
    }


}
