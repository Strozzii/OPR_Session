package klausur_1;

import java.util.List;
import java.util.stream.Collectors;

public class OnlineBanking {

    private static PINregel regel;

    public void setzePINregel(PINregel regel){
        this.regel = regel;
    }

    public static List<String> pin (List<String> a, PINregel b) {
        return a.stream()
                .filter(c -> b.istZulaessig(c))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        OnlineBanking ob = new OnlineBanking();
        ob.setzePINregel(pin -> pin.length() >= 5 && pin.charAt(0) != pin.charAt(pin.length() - 1));

        //OnlineBanking ob1 = new OnlineBanking();
        //ob1.setzePINregel(pin -> false);

        System.out.println(regel.istZulaessig("ababaaanab"));
    }

}
