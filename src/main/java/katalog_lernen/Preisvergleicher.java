package katalog_lernen;

import java.util.Comparator;

public class Preisvergleicher implements Comparator<Verkaufbares> {

    @Override
    public int compare(Verkaufbares o1, Verkaufbares o2) {
        return (int) Math.signum(o1.getPreis() - o2.getPreis());
    }
}
