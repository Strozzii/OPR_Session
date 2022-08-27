package ausdruck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    private Ausdruck sollAusdruck;
    private Parser parser;

    @BeforeEach
    void setUp(){
        sollAusdruck = new Operatorausdruck
                (
                        new Operatorausdruck
                                (new Variable("a"), '+', new Konstante(1)),
                        '*',
                        new Konstante(5)
                );

        parser = new Parser();

    }

    @Test
    void testparse(){
        assertEquals(sollAusdruck, parser.parse("(a + 1) * 5"));
    }


}