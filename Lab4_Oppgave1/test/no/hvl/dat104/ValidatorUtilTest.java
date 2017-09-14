package no.hvl.dat104;

import no.hvl.dat104.util.ValidatorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorUtilTest {
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
    void validerTall() {
        assertTrue(ValidatorUtil.isValidNumber(in7));
    }

    @Test
    void validerUgyldigStreng() {
        assertFalse(ValidatorUtil.isValidNumber(in4));
    }

    @Test
    void validerNavn() {
        assertTrue(ValidatorUtil.isValidString(in4));
    }

    @Test
    void validerTomStreng() {
        assertFalse(ValidatorUtil.isValidString(in5));
    }

    @Test
    void validerNull() {
        assertFalse(ValidatorUtil.isValidString(in6));
    }

    @Test
    void validerUgyldigeTall() {
        assertFalse(ValidatorUtil.isValidString(in7));
    }

    @Test
    void validerUgyligeSymboler() {
        assertFalse(ValidatorUtil.isValidString(in8));
    }

    @Test
    void escapeHtmlHTML() {
        assertEquals(r1, ValidatorUtil.escapeHtml(in1));
    }

    @Test
    void escapeHtmlNavn() {
        assertEquals(in4, ValidatorUtil.escapeHtml(in4));
    }

    @Test
    void escapeHtmlEmpty() {
        assertEquals(in5, ValidatorUtil.escapeHtml(in5));
    }

    @Test
    void escapeHtmlNull() {
        assertNull(ValidatorUtil.escapeHtml(in6));
    }

    @Test
    void escapeHtmlAPI() {
    }

    @Test
    void validerSubmit() {
    }
}