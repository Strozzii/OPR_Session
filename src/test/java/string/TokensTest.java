package string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TokensTest {

    private String st;
    private String[] starray;
    private String[] tokens;

    @BeforeEach
    void setUp(){
        st = "Dennis,Tom,Sylvi,Fynn";
        starray = new String[]{"Dennis", "Tom", "Sylvi", "Fynn"};
        tokens = Tokens.tokens(st, ",");
    }

    @Test
    void testTokens1(){
        assertEquals("Dennis", Tokens.tokens(st,",")[0]);
    }

    @Test
    void testTokens2(){
        assertEquals("Tom", Tokens.tokens(st,",")[1]);
    }

    @Test
    void testTokens3(){
        assertNotSame("Dennis", tokens[0]);
    }

    @Test
    void testTokens4(){
        assertNotEquals(starray, Tokens.tokens(st,","));
    }
}