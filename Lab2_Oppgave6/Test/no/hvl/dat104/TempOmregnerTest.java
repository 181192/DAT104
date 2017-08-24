/**
 * 
 */
package no.hvl.dat104;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author krist
 *
 */
public class TempOmregnerTest {
	private TempOmregner to;
	private String t1 = "27.4";
	private Double d1 = 27.4;
	
	@Before
	public void setup() {
		to = new TempOmregner();
	}
	
	@Test
	public final void skjekkInputTempDouble() {
		assertEquals(d1, to.skjekkInputTemperatur(t1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public final void skjekkInputTempNull() throws IllegalArgumentException{
		to.skjekkInputTemperatur(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public final void skjekkInputTempTom() throws IllegalArgumentException{
		to.skjekkInputTemperatur("");
	}

}
