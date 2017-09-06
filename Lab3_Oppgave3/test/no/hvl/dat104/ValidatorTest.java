package no.hvl.dat104;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private String in1 = "<h1 style=\"font-size:\n" +
            "20em;position:absolute;top:0;left:0;margin:0;padding:0;\n" +
            "background:red\">Hei</h1>";
    private String in2 = "<img src=”\n" +
            "https://www.google.no/images/branding/googlelogo/2x/googlelogo_color\n" +
            "_272x92dp.png” />";
    private String in3 = "<script type=\"text/javascript\">\n" +
            "window.location=\"http://www.hvl.no\"</script>\n";
    private String in4 = "Ola Nordman";
    private String in5 = "";
    private String in6 = null;
    private String in7 = "1234567";
    private String in8 = "@\"'*^%¤#";

    /*
     * < = &lt;
     * > = &gt;
     * " = &quot;
     * & = &amp;
     */
    private String r1 = "&lt;h1 style=&quot;font-size:\n" +
            "20em;position:absolute;top:0;left:0;margin:0;padding:0;\n" +
            "background:red&quot;&gt;Hei&lt;/h1&gt;";


    @BeforeEach
    void setUp() {

    }

    @Test
    void validerNavn() {
        assertTrue(Validator.validerNavn(in4));
    }

    @Test
    void validerTomStreng() {
        assertFalse(Validator.validerNavn(in5));
    }

    @Test
    void validerNull() {
        assertFalse(Validator.validerNavn(in6));
    }

    @Test
    void validerUgyldigeTall() {
        assertFalse(Validator.validerNavn(in7));
    }

    @Test
    void validerUgyligeSymboler() {
        assertFalse(Validator.validerNavn(in8));
    }

    @Test
    void escapeHtmlHTML() {
        assertEquals(r1, Validator.escapeHtml(in1));
    }

    @Test
    void escapeHtmlNavn() {
        assertEquals(in4, Validator.escapeHtml(in4));
    }

    @Test
    void escapeHtmlEmpty() {
        assertEquals(in5, Validator.escapeHtml(in5));
    }

    @Test
    void escapeHtmlNull() {
        assertNull(Validator.escapeHtml(in6));
    }

    @Test
    void escapeHtmlAPI() {
    }

}