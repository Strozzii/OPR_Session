package lernsession;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Streams {

    public static Collection<String> erzeugeListe(){
        Collection<String> l = new HashSet<>();
        l.add("abc");
        l.add("124");
        l.add("hallo i bims");
        l.add("");
        l.add(" ");
        l.add("ab12da");
        l.add("2456");
        return l;
    }

    public static void test1(){
        int s = erzeugeListe().stream()
                .filter(n -> n.matches("[0-9]+"))
                .mapToInt(Integer::parseInt)
                .filter(n -> n%2 == 0)
                .sum();
        System.out.println(s);
    }

    private static void test2() {
        IntStream.iterate(0, n -> n + 1)
                .limit(100)
                .filter(n -> n%7 == 0 && n%2 == 0)
                .forEach(System.out::println);
    }

    private static void test3(){

    }

    public static void main(String[] args) {
        //test1();
        //test2();


    }


}
