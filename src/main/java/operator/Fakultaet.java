package operator;

public class Fakultaet extends Operator{

    private double argument = 10.0;

    @Override
    public double wendeAn(double argument) {
        return argument < 2 ? 1
                            : argument * wendeAn(argument - 1);
    }

    public String gibName(){
        return "Fakultaet";
    }

    @Override
    public String gibKonstruktor() {
        return "new Fakultaet()";
    }

    @Override
    public double gibArgument() {
        return this.argument;
    }

    @Override
    public double gibWert() {
        return this.wendeAn(this.argument);
    }


}
