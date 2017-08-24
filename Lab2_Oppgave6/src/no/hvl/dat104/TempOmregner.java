/**
 * 
 */
package no.hvl.dat104;

/**
 * @author krist
 *
 */
public class TempOmregner {
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

	public boolean skjekkInputEnhet(String enhet) {
		return enhet != null;
	}

	public double regnTemperatur(Double temp, String enhet) {
		if (enhet.equals("celsius")) {
			return fraCelsiusTilFahrenheit(temp);
		} else {
			return fraFahrenheitTilCelsius(temp);
		}
	}

	private double fraCelsiusTilFahrenheit(double celsius) {
		return ((celsius * 1.8) + 32);
	}

	private double fraFahrenheitTilCelsius(double fahrenheit) {
		return ((fahrenheit - 32) / 1.8);
	}
}
