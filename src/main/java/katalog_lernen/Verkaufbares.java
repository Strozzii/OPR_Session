package katalog_lernen;

public interface Verkaufbares {

    boolean passtZu(String suchbegriff);

    String gibText();

    float getPreis();
}
