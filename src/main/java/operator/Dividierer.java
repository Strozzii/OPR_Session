package operator;

public class Dividierer extends BinaererOperator{

    private double argument = 3.0;

    public Dividierer(double wert) {
        super(wert);
    }

    @Override
    public double wendeAn(double argument) {
        return argument / this.wert;
    }

    @Override
    public String gibName() {
        return "Addition";
    }

    @Override
    public String gibKonstruktor() {
        return "new Dividierer(" + this.wert + ")";
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
