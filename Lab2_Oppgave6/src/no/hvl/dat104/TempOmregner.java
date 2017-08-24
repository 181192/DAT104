/**
 * 
 */
package no.hvl.dat104;

import java.text.DecimalFormat;

/**
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class TempOmregner {

	/**
	 * Skjekker input for temperatur
	 * 
	 * @param temp
	 *            Temperatur som en streng
	 * @return Temperaturen som en Double
	 * @throws IllegalArgumentException
	 *             Kaster exception hvis strenger er tom eller null.
	 */
	public Double skjekkInputTemperatur(String temp) throws IllegalArgumentException {
		Double t = 0.0;
		if (temp == null || temp == "") {
			throw new IllegalArgumentException("Temp input er tom");
		}

		try {
			t = Double.parseDouble(temp);
		} catch (NumberFormatException nfe) {
			System.err.println("Temperatur input: " + nfe.getMessage());
		}

		return t;
	}

	/**
	 * Skjekker input for temperatur enhet
	 * 
	 * @param enhet
	 *            Temperatur enhet
	 * @return Lovlig temperatur type
	 * @throws IllegalArgumentException
	 *             Kaster exception hvis strengen er tom eller null.
	 */
	public String skjekkInputEnhet(String enhet) throws IllegalArgumentException {
		if (enhet == null || enhet == "") {
			throw new IllegalArgumentException("Enhet input er tom");
		}

		return enhet;
	}

	/**
	 * Regner ut temperaturen, ut ifra hvilken type temperatur enhet som gies.
	 * 
	 * @param temp
	 *            Temperaturen som skal omregnes
	 * @param enhet
	 *            Temperatur enheten temperaturen oppgies i
	 * @return Temperaturen omregnet til enten Celsius eller Fahrenheit
	 */
	public String regnTemperatur(Double temp, String enhet) {
		DecimalFormat df = new DecimalFormat("####0.00");
		Double svar;
		if (enhet.equals("celsius")) {
			svar = fraCelsiusTilFahrenheit(temp);
		} else {
			svar = fraFahrenheitTilCelsius(temp);
		}
		return df.format(svar).replace(",", ".");
	}

	/**
	 * Hjelpemetode for å konventere fra celsius til fahrenheit
	 * 
	 * @param celsius
	 * @return fahrenheit
	 */
	private Double fraCelsiusTilFahrenheit(Double celsius) {
		return ((celsius * 1.8) + 32);
	}

	/**
	 * Hjelpemetode for å konventere fra fahrenheit til celsius
	 * 
	 * @param fahrenheit
	 * @return celsius
	 */
	private Double fraFahrenheitTilCelsius(Double fahrenheit) {
		return ((fahrenheit - 32) / 1.8);
	}
}
