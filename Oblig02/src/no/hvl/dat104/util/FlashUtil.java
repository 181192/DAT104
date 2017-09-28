/**
 * 
 */
package no.hvl.dat104.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author krist
 *
 */
public class FlashUtil {

	/**
	 * Flash melding
	 * 
	 * @param request
	 * @param flash
	 *            Success eller error
	 * @param melding
	 *            Melding som skal vises til brukeren
	 */
	public static void flash(HttpServletRequest request, String flash, String melding) {
		if (validateFlashType(flash)) {
			request.getSession().setAttribute("flash", flash);
			request.getSession().setAttribute("melding", melding);
		}
	}

	/**
	 * Skjekker at flash typen er riktig
	 * 
	 * @param f
	 *            success eller error
	 * @return true / false
	 */
	private static boolean validateFlashType(String f) {
		String regex = "^(success|error|auth)$";
		return (f != null) && f.matches(regex);
	}

}
