package operator;

public class Addierer extends BinaererOperator {

    private double argument = 10.0;

    public Addierer(double wert) {
        super(wert);
    }

    @Override
    public double wendeAn(double argument) {
        return this.wert + argument;
    }

    @Override
    public String gibName() {
        return "Addition";
    }

    @Override
    public String gibKonstruktor() {
        return "new Addierer(" + this.wert + ")";
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
