package operator;

public class OperatorTest {
    public static void main(String[] args) {

        Operator op = new Addierer(5);
        System.out.println(op.gibInfo());

        op = new Dividierer(5);
        System.out.println(op.gibInfo());

        op = new Fakultaet();
        System.out.println(op.gibInfo());
    }
}
