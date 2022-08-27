package ausdruck;

public class Variable extends Ausdruck{

    private String name;

    public Variable(String name){
        this.name = name;
    }

    @Override
    public int gibWert(Variablenbelegung var) {
        return 0;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if(obj instanceof Variable){
            isEqual = this.name.equals(((Variable)obj).name);
        }
        return isEqual;
    }


}
