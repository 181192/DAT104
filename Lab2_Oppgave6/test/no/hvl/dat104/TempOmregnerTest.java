/**
 * 
 */
package no.hvl.dat104;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class TempOmregnerTest {
	private TempOmregner to;
	private String t1 = "27.4";
	private String t2 = "81.3";
	private String C = "celsius";
	private String F = "fahrenheit";

	@Before
	public void setup() {
		to = new TempOmregner();
	}

	/**
	 * Regner om fra Celsius til Fahrenheit.
	 */
	@Test
	public final void regnCelsius() {
		assertEquals(t2, to.regnTemperatur(t1, C));
	}

	/**
	 * Regner om fra Fahrenheit til Celsius
	 */
	@Test
	public final void regnFahrenheit() {
		assertEquals(t1, to.regnTemperatur(t2, F));
	}
}
