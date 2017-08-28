package no.hvl.dat104;

import no.hvl.dat104.lph.ExchangeRate;
import no.hvl.dat104.lph.ExchangeRateService;

import java.io.IOException;
import java.util.Currency;

public class Omregner {

    /**
     * Validerer riktig belop
     * @param s Belopet
     * @return True / false
     */
	public boolean isValidBelop(String s) {
		return s != null && s.matches("^\\d{1,12}(|[.]\\\\d+)$");
	}
	
	/**
	 * Beregner valutaen ved hjelp av ExchangeRate og ExchangerateService
	 * @param fraValuta
	 * @param fraValutaEnhet
	 * @param tilValutaEnhet
	 * @return
	 * @throws IOException
	 */
	public double beregnValuta(
			double fraValuta, 
			String fraValutaEnhet,  
			String tilValutaEnhet) throws IOException {
		
		ExchangeRate rate = ExchangeRateService.getRate(fraValutaEnhet, tilValutaEnhet);

		return rate.getRate() * fraValuta;
	}
	
	/**
	 * Validerer om riktig valuta enhet kommer fra brukeren
	 * @param valuta
	 * @return Valuta eller null
	 */
	public boolean isValidEnhet(String valuta) {
	    if (valuta != null) {
            for (Currency c : Currency.getAvailableCurrencies()) {
                if (c.getCurrencyCode().equals(valuta)) {
                    return true;
                }
            }
        }
		return false;
	}

}
