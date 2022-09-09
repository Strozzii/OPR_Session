package katalog_lernen;

import java.util.*;

public abstract class Katalogartikel implements Verkaufbares {

    private final float preis;
    private static final Set<String> AUSSCHLUSSWOERTER = new HashSet<>(Arrays.asList("der", "die", "das", "und", "oder"));

    public Katalogartikel(float preis){
        this.preis = preis;
    }
    public static boolean istAusschlusswort(String wort){
        return (AUSSCHLUSSWOERTER.contains(wort));
    }

    public boolean passtZuStream(String such){
        StringTokenizer st = new StringTokenizer(this.gibSuchtext());

        return Collections.list(st)
                .stream()
                .anyMatch(t -> ((String) t).startsWith(such) && !istAusschlusswort((String) t));

    }

    @Override
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

    @Override
    public float getPreis(){
        return preis;
    }

    @Override
    public abstract String gibText();

    protected abstract String gibSuchtext();

}
