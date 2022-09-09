package katalog_lernen;

import java.util.StringTokenizer;

public abstract class Katalogartikel {

    private final float preis;
    private static final String[] AUSSCHLUSSWOERTER = new String[]{"der", "die", "das", "und", "oder"};

    public Katalogartikel(float preis){
        this.preis = preis;
    }
    public static boolean istAusschlusswort(String wort){
        int i = 0;

        while((i < AUSSCHLUSSWOERTER.length) && (!AUSSCHLUSSWOERTER[i].equalsIgnoreCase(wort))){
            i++;
        }

        return (i < AUSSCHLUSSWOERTER.length);
    }

    public boolean passtZu(String such){
        StringTokenizer st = new StringTokenizer(this.gibSuchtext());
        boolean gefunden = false;

        while(st.hasMoreTokens() && !gefunden){
            String token = st.nextToken();
            if(token.startsWith(such) && !istAusschlusswort(token)){
                gefunden = true;
            }
        }
        return gefunden;
    }


    protected float getPreis(){
        return preis;
    }

    public abstract String gibText();

    protected abstract String gibSuchtext();

}
