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
	 * Regner ut temperaturen, ut ifra hvilken type temperatur enhet som gies.
	 * 
	 * @param temp
	 *            Temperaturen som skal omregnes
	 * @param enhet
	 *            Temperatur enheten temperaturen oppgies i
	 * @return Temperaturen omregnet til enten Celsius eller Fahrenheit
	 */
	public String regnTemperatur(String temp, String enhet) {
		Double tempD = Double.parseDouble(temp);
		DecimalFormat df = new DecimalFormat("####0.0");
		Double svar;
		if (enhet.equals("celsius")) {
			svar = fraCelsiusTilFahrenheit(tempD);
		} else {
			svar = fraFahrenheitTilCelsius(tempD);
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
