package no.hvl.dat104;

public class Validator {
    public static boolean isValidFruit(String fruit) {
        return fruit != null && fruit.matches("^\\d+$");
    }
}
