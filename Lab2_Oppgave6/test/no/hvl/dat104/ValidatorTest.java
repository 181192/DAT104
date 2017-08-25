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
	private String v0 = "27.4";
	private String v1 = "2";
	private String v2 = "-234";
	private String v3 = "-23.3";
	private String v4 = "2344";

	@Before
	public void setup() {
		v = new Validator();
	}

	/**
	 * Skjekker om input tar imot negative, positive, med og uten komma tall
	 */
	@Test
	public final void skjekkInputTempDouble() {
		assertTrue(v.isValidTemperatur(v0));
		assertTrue(v.isValidTemperatur(v1));
		assertTrue(v.isValidTemperatur(v2));
		assertTrue(v.isValidTemperatur(v3));
		assertFalse(v.isValidTemperatur(v4));
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
