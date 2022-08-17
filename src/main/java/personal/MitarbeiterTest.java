package personal;

public class MitarbeiterTest {
    public static void main(String[] args) {
        Mitarbeiter winkelmann = new Mitarbeiter("Walter Winkelmann");
        Vorgesetzter wichtig = new Vorgesetzter("Waltraud Wichtig");
        Vorgesetzter wichtiger = new Vorgesetzter("Hermann Wichtiger");

        winkelmann.setzeVorgesetzten(wichtig);
        wichtig.setzeVorgesetzten(wichtiger);

        System.out.println(winkelmann.darfBestellen(15));
        System.out.println(winkelmann.darfBestellen(20));
        System.out.println(winkelmann.darfBestellen(21));
        System.out.println(wichtiger.darfBestellen(15));
        System.out.println(wichtiger.darfBestellen(25));

        Mitarbeiter.setzeAllgemeinesLimit(30);

        Mitarbeiter winzig = new Mitarbeiter("Willi Winzig");

        System.out.println(winkelmann.darfBestellen(21));
        System.out.println(wichtiger.darfBestellen(25));

        wichtig.setzeBestelllimit(10);

        System.out.println(wichtig.darfBestellen(10));
        System.out.println(wichtig.darfBestellen(11));

        wichtig.setzeBestelllimit(5000);

        System.out.println(wichtig.darfBestellen(2000));
        System.out.println(wichtig.darfBestellen(7000));

        System.out.println(wichtig.gibInfo());

        System.out.println(wichtig.gibHierarchie());

        System.out.println(wichtiger.gibInfo());

        System.out.println(wichtiger.gibHierarchie());

        System.out.println(winkelmann.gibInfo());

        System.out.println(winkelmann.gibHierarchie());

        wichtig.setzeVorgesetzten(null);

        System.out.println(winkelmann.gibHierarchie());

        System.out.println(winzig.gibInfo());

        System.out.println(winzig.gibHierarchie());


    }
}
