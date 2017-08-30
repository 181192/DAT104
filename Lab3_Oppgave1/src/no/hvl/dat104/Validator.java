package no.hvl.dat104;

public class Validator {

    /**
     * Validerer navnet om det er riktig, tillatter alle
     * unicode bokstaver fra alle språk samt -, ' og whitespaces
     *
     * @param navn Navnet som skal valideres
     * @return True eller false
     */
    boolean validerNavn(String navn) {
        return navn != null && navn.matches("^[\\p{L}\\-\'\\s]+$");
    }

    /**
     * Renser strengen for <, >, &, ' med html encoding
     *
     * @param s Strengen som skal renses
     * @return Renset streng eller null
     */
    String rensInputManuell(String s) {
        if (s != null) {
            return s
                    .replaceAll("&", "&amp;")
                    .replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;")
                    .replaceAll("\"", "&quot;");
        }
        return null;
    }

    public String rensInput(String s) {
        return null;
    }


}
