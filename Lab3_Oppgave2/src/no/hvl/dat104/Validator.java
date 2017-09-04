package no.hvl.dat104;

class Validator {
    static boolean isValidFruit(String fruit) {
        return fruit != null && fruit.matches("^\\d+$");
    }
}
