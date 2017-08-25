/**
 * 
 */
package no.hvl.dat104;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class ValidatorTest {
	private Validator v;
	private String t1 = "27.4";
	private String t2 = "81.3";
	private String C = "celsius";
	private String F = "fahrenheit";

	@Before
	public void setup() {
		v = new Validator();
	}

	/**
	 * Skjekker om input tar imot en Streng og spytter ut en Double
	 */
	@Test
	public final void skjekkInputTempDouble() {
		assertTrue(v.isValidTemperatur(t1));
	}

	/**
	 * Skjekker om input kaster exception når strengen er null.
	 */
	@Test
	public final void skjekkInputTempNull() {
		assertFalse(v.isValidTemperatur(null));
	}

	/**
	 * Skjekker om input kaster exception når strengen er tom.
	 */
	@Test
	public final void skjekkInputTempTom() {
		assertFalse(v.isValidTemperatur(""));
	}

}
