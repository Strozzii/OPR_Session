package zahlenfolge;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class PushBackFolge implements Zahlenfolge{

    private Zahlenfolge folge;
    private LinkedList<Integer> queue;

    public PushBackFolge(Zahlenfolge folge){
        this.folge = folge;
        queue = new LinkedList<>();
    }

    public void schreibeZurueck(int num){
        queue.addFirst(num);
    }

    @Override
    public boolean hatNaechstes() {
        return (folge.hatNaechstes() || !queue.isEmpty());
    }

    @Override
    public int gibNaechstes() throws NoSuchElementException {
        int output;
        if(!queue.isEmpty()){
            output = queue.getFirst();
            queue.removeFirst();
        } else if(folge.hatNaechstes()){
            output = folge.gibNaechstes();
        } else {
            throw new NoSuchElementException("Naechstes Element nicht gefunden!");
        }

        return output;
    }
}
