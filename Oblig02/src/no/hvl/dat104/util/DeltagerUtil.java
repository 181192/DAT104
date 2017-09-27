/**
 * 
 */
package no.hvl.dat104.util;

import javax.servlet.http.HttpServletRequest;

import no.hvl.dat104.dataaccess.IDeltagerEAO;
import no.hvl.dat104.model.DeltagerEntity;

/**
 * @author krist
 *
 */
public class DeltagerUtil {

	/**
	 * Henter input fra skjema, validerer nummeret og henter deltageren hvis den
	 * finnes i databasen
	 * 
	 * @param request
	 * @param deltagerEAO
	 * @return Null eller en deltager
	 */
	public static DeltagerEntity hentDeltager(HttpServletRequest request, IDeltagerEAO deltagerEAO) {
		String nummer = ValideringUtil.escapeHTML(request.getParameter("password"));
		if (!ValideringUtil.validerNummer(nummer)) {
			return null;
		}
		return deltagerEAO.finnDeltager(Integer.parseInt(nummer));
	}

}
