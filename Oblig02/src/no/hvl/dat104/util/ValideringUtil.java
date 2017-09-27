/**
 * 
 */
package no.hvl.dat104.util;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * @author krist
 *
 */
public class ValideringUtil {

	/**
	 * Fornavn skal være 2-20 tegn og kan inneholde bokstaver(inkl. øæåØÆÅ),
	 * bindestrek og mellomrom. Første tegn skal være en stor bokstav
	 * 
	 * @param s
	 *            Fornavn
	 * @return True eller False
	 */
	public static boolean validerFornavn(String s) {
		String regex = "^[A-ZØÆÅ]([a-zøæå\\']|(\\-|\\s)[A-ZØÆÅ]){1,19}$";
		return (s != null) && s.matches(regex);
	}

	/**
	 * Etternavn skal være 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ) og
	 * bindestrek (IKKE mellomrom). Første tegn skal være en stor bokstav.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean validerEtternavn(String s) {
		String regex = "^[A-ZØÆÅ]([a-zøæå\\']|\\-[A-ZØÆÅ]){1,19}$";
		return (s != null) && s.matches(regex);
	}

	/**
	 * Mobil skal være eksakt 8 siffer, ingenting annet.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean validerNummer(String s) {
		String regex = "^\\d{8}$";
		return (s != null) && s.matches(regex);
	}

	public static String escapeHTML(String s) {
		return StringEscapeUtils.escapeHtml(s);
	}
}
