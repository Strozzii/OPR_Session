package ausdruck;

public class Konstante extends Ausdruck{

    private int value;

    public Konstante(int value){
        this.value = value;
    }

    @Override
    public int gibWert(Variablenbelegung var) {
        return 0;
    }

    @Override
    public boolean equals(Object obj){
        boolean isEqual = false;
        if(obj instanceof Konstante){
            isEqual = ((Konstante)obj).value == this.value;
        }
        return isEqual;
    }

    @Override
    public int hashCode(){
        return value;
    }
}
