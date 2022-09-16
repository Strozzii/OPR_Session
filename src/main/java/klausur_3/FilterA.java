package klausur_3;

public class FilterA implements Filterkriterium{

    @Override
    public boolean laesstDurch(String wort) {
        return wort.length() > 10;
    }
}
