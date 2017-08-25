/**
 * 
 */
package no.hvl.dat104;

/**
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Validator {

	/**
	 * Skjekker om temperaturen er ett positivt eller negativt tall med maks tre
	 * desimaler (RegEx)
	 * 
	 * @param s
	 *            Streng som skal valideres
	 * @return True, hvis strengen er korrekt, false ellers.
	 */
	public boolean isValidTemperatur(String s) {
		return s != null && s.matches("^(|-)\\d{1,3}(|[.]\\d+)$");
	}

	/**
	 * Skjekker om temperatur enheten er enten celsius eller fahrenheit (RegEx)
	 * 
	 * @param s
	 *            Streng som skal valideres
	 * 
	 * @return True, hvis strengen er korrekt, false ellers
	 */
	public boolean isValidTempUnit(String s) {
		return s != null && s.matches("^(celsius|fahrenheit)$");
	}
}
