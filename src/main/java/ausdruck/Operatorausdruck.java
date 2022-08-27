package ausdruck;

public class Operatorausdruck extends Ausdruck{

    private Ausdruck a1;
    private Ausdruck a2;
    private char op;

    public Operatorausdruck(Ausdruck a1, char op, Ausdruck a2){
        this.a1 = a1;
        this.a2 = a2;
        this.op = op;
    }

    @Override
    public int gibWert(Variablenbelegung var) {
        return 0;
    }

    @Override
    public int hashCode() {
        return a1.hashCode() + a2.hashCode() + op;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if(obj instanceof Operatorausdruck){
            isEqual = a1.equals(((Operatorausdruck)obj).a1)
                    && a2.equals(((Operatorausdruck)obj).a2)
                    && op == ((Operatorausdruck)obj).op;
        }
        return isEqual;
    }
}
