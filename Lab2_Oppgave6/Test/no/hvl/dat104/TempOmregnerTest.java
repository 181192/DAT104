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
	private String t1 = "27.40";
	private String t2 = "81.32";
	private Double d1 = 27.4;
	private Double d2 = 81.32;
	private String C = "celsius";
	private String F = "fahrenheit";

	@Before
	public void setup() {
		to = new TempOmregner();
	}

	/**
	 * Skjekker om input tar imot en Streng og spytter ut en Double
	 */
	@Test
	public final void skjekkInputTempDouble() {
		assertEquals(d1, to.skjekkInputTemperatur(t1));
	}

	/**
	 * Skjekker om input kaster exception når strengen er null.
	 * 
	 * @throws IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void skjekkInputTempNull() throws IllegalArgumentException {
		to.skjekkInputTemperatur(null);
	}

	/**
	 * Skjekker om input kaster exception når strengen er tom.
	 * 
	 * @throws IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void skjekkInputTempTom() throws IllegalArgumentException {
		to.skjekkInputTemperatur("");
	}

	/**
	 * Regner om fra Celsius til Fahrenheit.
	 */
	@Test
	public final void regnCelsius() {
		assertEquals(t2, to.regnTemperatur(d1, C));
	}

	/**
	 * Regner om fra Fahrenheit til Celsius
	 */
	@Test
	public final void regnFahrenheit() {
		assertEquals(t1, to.regnTemperatur(d2, F));
	}
}
