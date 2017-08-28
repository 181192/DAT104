package no.hvl.dat104;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OmregnerTest {
    private Omregner o;
    private String NOK = "NOK";
    private String USD = "USD";
    private String GBP = "GBP";

    @Before
    public void setUp() {
        o = new Omregner();
    }

    @Test
    public void veksleTilSammeValuta() throws Exception {
        assertEquals(100, o.beregnValuta(100, NOK, NOK), 0.01);
        assertEquals(100, o.beregnValuta(100, USD, USD), 0.01);
        assertEquals(100, o.beregnValuta(100, GBP, GBP), 0.01);
    }

    @Test
    public void veksleNullTilEnAnnenValuta() throws Exception {
        assertEquals(0, o.beregnValuta(0, NOK, USD), 0.01);
    }

    @Test
    public void ugyldigValutaEnhet() {
        assertTrue(o.isValidEnhet(NOK));
        assertTrue(o.isValidEnhet(USD));
        assertFalse(o.isValidEnhet("GPD"));
        assertFalse(o.isValidEnhet(""));
    }

    @Test
    public void lesFraFil() {
        boolean tilstand = false;
        for (Valuta v : ValutaService.lesFraFil("resources/valuta.csv")) {
            if (v != null) {
                System.out.println(v.getKode() + " " + v.getNavn());
                tilstand = true;
            } else {
                tilstand = false;
            }
        }
        assertTrue(tilstand);
    }

}