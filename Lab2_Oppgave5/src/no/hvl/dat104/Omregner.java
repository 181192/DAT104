package no.hvl.dat104;

import java.io.IOException;

import no.hvl.dat104.lph.ExchangeRate;
import no.hvl.dat104.lph.ExchangeRateService;

public class Omregner {
	
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
	public String validerValutaEnhet(String valuta) {
		return null;
	}
}
