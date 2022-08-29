package ausdruck;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Ein Objekt dieser Klasse repräsentiert einen Parser für geklammerte
 * arithmetische Ausdrücke. Die Ausdrücke haben folgende Syntax:
 * <ul>
 * <li>Ausdruck ::= Summand | Summand ("+" | "-") Summand</li>
 * <li>Summand ::= Faktor | Faktor ("*" | "/") Faktor</li>
 * <li>Faktor ::= Konstante | Variable | "(" Ausdruck ")"</li>
 * <li>Konstante: Dezimaldarstellung einer natürlichen Zahl</li>
 * <li>Variable: alphanummerische Zeichenfolge, beginnend mit einem
 * Buchstaben</li>
 * </ul>
 */
public class Parser {

    /**
     * Liste der Tokens des Textausdrucks, der geparst wird.
     */
    private ArrayList<String> tokens;

    /**
     * Index des nächsten zu verarbeitenden Tokens.
     */
    private int index;

    /**
     * Initialisiert die Tokenliste dieses Parsers für den angegebenen Text. Die
     * Token des Texts ergeben sich durch Aufteilung mittels der Trennzeichen +,
     * -, *, /, (, ) und des Leerzeichens. Alle Trennzeichen mit Ausnahme des
     * Leerzeichens sind, sofern sie im Text auftreten, selbst Tokens.
     *
     * @param text Text, der geparst werden soll
     */
    private void initialisiere(String text) {

        StringTokenizer st = new StringTokenizer(text, " +-*/()", true);
        tokens = new ArrayList<String>();

        /*
         * Über die Tokens iterieren, dabei Leerzeichen überspringen.
         */
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (!" ".equals(token)) {
                tokens.add(token);
            }
        }
        index = 0;
    }

    /**
     * Prüft, ob das aktuelle Token eine gültige Darstellung einer natürlichen
     * Zahl ist.
     *
     * @return <code>true</code> genau dann, wenn das aktuelle Token eine
     *         gültige Darstellung einer natürlichen Zahl ist
     */
    private boolean istZahl() {

        String zahl = tokens.get(index);
        return zahl.matches("[0-9]+");
    }

    /**
     * Prüft, ob das aktuelle Token eine gültige Darstellung einer Variable ist.
     *
     * @return <code>true</code> genau dann, wenn das aktuelle Token eine
     *         gültige Darstellung einer Variablen ist
     */
    private boolean istVariable() {

        String variable = tokens.get(index);
        return variable.matches("[a-zA-Z][0-9a-zA-Z]*");
    }

    /**
     * Verarbeitet ab dem aktuellen Token eine längstmögliche Folge von Tokens,
     * die einen gültigen Ausdruck bildet. Dieser Ausdruck wird geliefert.
     *
     * @return längstmöglicher Ausdruck ab dem aktuellen Token
     */
    private Ausdruck parseAusdruck() {

        /*
         * ersten Summanden erkennen
         */
        Ausdruck ausdruck = this.parseSummand();

        /*
         * solange Tokens verarbeiten, wie noch ein Operator + oder - kommt
         */
        while (index < tokens.size()
                && ("+".equals(tokens.get(index))
                || "-".equals(tokens.get(index)))) {

            char operator;
            Ausdruck operand2;

            operator = tokens.get(index).charAt(0);
            index++;  // zum nächsten Token
            operand2 = this.parseSummand();  // nächsten Summanden erkennen

            ausdruck = new Operatorausdruck(ausdruck, operator, operand2);
        }

        return ausdruck;
    }

    /**
     * Verarbeitet ab dem aktuellen Token eine längstmögliche Folge von Tokens,
     * die einen gültigen Summand bilden. Dieser wird als Objekt der Klasse
     * Ausdruck geliefert.
     *
     * @return längstmöglicher Summand ab dem aktuellen Token
     */
    private Ausdruck parseSummand() {

        /*
         * ersten Faktor erkennen
         */
        Ausdruck ausdruck = this.parseFaktor();

        /*
         * solange Tokens verarbeiten, wie noch ein Operator * oder / kommt
         */
        while (index < tokens.size()
                && ("*".equals(tokens.get(index))
                || "/".equals(tokens.get(index)))) {

            char operator;
            Ausdruck operand2;

            operator = tokens.get(index).charAt(0);
            index++;  // zum nächsten Token
            operand2 = this.parseFaktor();  // nächsten Faktor erkennen

            ausdruck = new Operatorausdruck(ausdruck, operator, operand2);
        }

        return ausdruck;
    }

    /**
     * Verarbeitet ab dem aktuellen Token eine längstmögliche Folge von Tokens,
     * die einen gültigen Faktor bilden. Dieser wird als Objekt der Klasse
     * Ausdruck geliefert.
     *
     * @return längstmöglicher Faktor ab dem aktuellen Token
     */
    private Ausdruck parseFaktor() {

        Ausdruck ausdruck = null;
        String token;

        token = tokens.get(index);
        if ("(".equals(token)) {

            /*
             * Beginn eines geklammerten Ausdrucks
             */

            /*
             * Ab nächstem Token Ausdruck erkennen.
             */
            index++;
            ausdruck = this.parseAusdruck();

            /*
             * Das aktuelle Token muss nun ")" sein.
             */
        } else if (istZahl()) {
            /*
             * Token ist eine Zahl
             */
            ausdruck = new Konstante(Integer.parseInt(token));
        } else if (istVariable()) {
            /*
             * Token ist eine Variable.
             */
            ausdruck = new Variable(token);
        }

        index++;  // zum nächsten Token
        return ausdruck;
    }

    /**
     * Erkennt den Ausdruck, der durch den angegebenen Text dargestellt wird und
     * liefert diesen Ausdruck.
     *
     * @param text Text, der geparst wird
     * @return Ausdruck, der durch übergebenen Text dargestellt wird
     */
    public Ausdruck parse(String text) throws ParseException {

        this.initialisiere(text);
        Ausdruck ausdruck = this.parseAusdruck();
        return ausdruck;
    }
}