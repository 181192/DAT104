package no.hvl.dat104;

public class Validator {

    /**
     * Validerer strengen om det er riktig, tillatter alle
     * unicode bokstaver fra alle språk samt -, ' og whitespaces
     *
     * @param streng Strengen som skal valideres
     * @return True eller false
     */
    public static boolean validerStreng(String streng) {
        return streng != null && streng.matches("^[\\p{L}\\-\'\\s]+$");
    }

    public static boolean validerSubmit(String submit) {
        return submit != null && (submit.equals("Slett") || submit.equals("Submit"));
    }

    /**
     * Renser strengen for <, >, &, ' med html encoding
     *
     * @param s Strengen som skal renses
     * @return Renset streng eller null
     */
    public static String escapeHtml(String s) {
        if (s != null) {
            return s
                    .replaceAll("&", "&amp;")
                    .replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;")
                    .replaceAll("\"", "&quot;");
        }
        return null;
    }

    public String escapeHtmlAPI(String s) {
        return null;
    }
}
