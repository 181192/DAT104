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
	 * Fornavn skal v�re 2-20 tegn og kan inneholde bokstaver(inkl. ������),
	 * bindestrek og mellomrom. F�rste tegn skal v�re en stor bokstav
	 * 
	 * @param s
	 *            Fornavn
	 * @return True eller False
	 */
	public static boolean validerFornavn(String s) {
		String regex = "^[A-Z���]([a-z���\\']|(\\-|\\s)[A-Z���]){1,19}$";
		return (s != null) && s.matches(regex);
	}

	/**
	 * Etternavn skal v�re 2-20 tegn og kan inneholde bokstaver (inkl. ������) og
	 * bindestrek (IKKE mellomrom). F�rste tegn skal v�re en stor bokstav.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean validerEtternavn(String s) {
		String regex = "^[A-Z���]([a-z���\\']|\\-[A-Z���]){1,19}$";
		return (s != null) && s.matches(regex);
	}

	/**
	 * Mobil skal v�re eksakt 8 siffer, ingenting annet.
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
