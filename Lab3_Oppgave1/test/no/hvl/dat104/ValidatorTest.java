package no.hvl.dat104;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private Validator v;
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
        v = new Validator();
    }

    @Test
    void validerNavn() {
        assertTrue(v.validerNavn(in4));
    }

    @Test
    void validerTomStreng() {
        assertFalse(v.validerNavn(in5));
    }

    @Test
    void validerNull() {
        assertFalse(v.validerNavn(in6));
    }

    @Test
    void validerUgyldigeTall() {
        assertFalse(v.validerNavn(in7));
    }

    @Test
    void validerUgyligeSymboler() {
        assertFalse(v.validerNavn(in8));
    }

    @Test
    void rensInputManuellHTML() {
        assertEquals(r1, v.rensInputManuell(in1));
    }

    @Test
    void rensInputManuellNavn() {
        assertEquals(in4, v.rensInputManuell(in4));
    }

    @Test
    void rensInputManuellEmpty() {
        assertEquals(in5, v.rensInputManuell(in5));
    }

    @Test
    void rensInputManuellNull() {
        assertNull(v.rensInputManuell(in6));
    }

    @Test
    void rensInput() {
    }

}