package zahlenfolge;

import java.util.NoSuchElementException;

public class EndlicheFolge implements Zahlenfolge {

    private int[] folge;
    private int index;

    public EndlicheFolge(int[] nums){
        folge = nums;
        index = 0;
    }

    @Override
    public boolean hatNaechstes() {
        return this.index < folge.length;
    }

    @Override
    public int gibNaechstes() throws NoSuchElementException {
        int output;
        if(this.hatNaechstes()){
            output = folge[index];
            index++;
        } else {
            throw new NoSuchElementException("Naechstes Element nicht gefunden!");
        }
        return output;
    }


}
