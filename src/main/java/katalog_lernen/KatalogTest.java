package katalog_lernen;

public class KatalogTest {

    public static void main(String[] args) {
        Katalog k = new Katalog();
        Buch b1 = new Buch("Harry Potter", "JK", 19.99f, 1998);
        Buch b2 = new Buch("Herr der Ringe", "Tolkien", 29.99f, 1935);

        k.fuegeHinzu(b1);
        k.fuegeHinzu(b2);

        k.gibBuecher();
    }
}
