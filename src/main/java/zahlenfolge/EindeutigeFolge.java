package zahlenfolge;

import java.util.NoSuchElementException;

public class EindeutigeFolge implements Zahlenfolge{

    private PushBackFolge folge;

    public EindeutigeFolge(Zahlenfolge folge){
        this.folge = new PushBackFolge(folge);
    }

    @Override
    public boolean hatNaechstes() {
        return folge.hatNaechstes();
    }

    @Override
    public int gibNaechstes() throws NoSuchElementException {
        if (folge.hatNaechstes()) {
            int ausgabe = folge.gibNaechstes();
            // 1 1 1 2
            if(folge.hatNaechstes()) {
                int next = folge.gibNaechstes();
                while(ausgabe == next && folge.hatNaechstes()) {
                    next = folge.gibNaechstes();
                }
                folge.schreibeZurueck(next);
            }
            return ausgabe;

        }else {

            throw new NoSuchElementException("Nächstes Element wurde nicht gefunden!");
        }
    }
}
