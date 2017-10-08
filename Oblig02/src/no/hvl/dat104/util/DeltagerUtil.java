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
	 *            Request
	 * @param deltagerEAO
	 *            DeltagerEAO
	 * @return Null eller en deltager
	 */
	public static DeltagerEntity hentDeltager(HttpServletRequest request, IDeltagerEAO deltagerEAO) {
		String nummer = ValideringUtil.escapeHTML((String) request.getParameter("password"));
		if (!ValideringUtil.validerNummer(nummer)) {
			return null;
		}
		return deltagerEAO.finnDeltager(Integer.parseInt(nummer));
	}

	/**
	 * Escape html på input, validerer input og legger til ny deltaker
	 * 
	 * @param request
	 *            Request
	 * @param deltagerEAO
	 *            DeltagerEAO
	 */
	public static DeltagerEntity leggTilDeltager(HttpServletRequest request, IDeltagerEAO deltagerEAO) {
		DeltagerEntity d = null;
		String fornavn = ValideringUtil.escapeHTML(request.getParameter("fornavn"));
		String etternavn = ValideringUtil.escapeHTML(request.getParameter("etternavn"));
		String mobil = ValideringUtil.escapeHTML(request.getParameter("mobil"));
		String kjoenn = ValideringUtil.escapeHTML(request.getParameter("kjoenn"));
		boolean erMann = kjoenn.equals("mann") ? true : false;

		if (ValideringUtil.validerFornavn(fornavn) && ValideringUtil.validerEtternavn(etternavn)
				&& ValideringUtil.validerNummer(mobil)) {
			Integer nummer = Integer.parseInt(mobil);
			if (deltagerEAO.finnDeltager(nummer) != null) {
				FlashUtil.flash(request, "error", "Beklager, deltageren er allerede registrert");
			} else {
				d = new DeltagerEntity(Integer.parseInt(mobil), fornavn, etternavn, erMann, false, false);
				deltagerEAO.leggTilDeltager(d);
			}
		}
		return d;
	}

}
