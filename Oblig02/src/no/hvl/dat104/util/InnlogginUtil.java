package no.hvl.dat104.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat104.model.DeltagerEntity;

public class InnlogginUtil {

	/**
	 * Sjekker om deltaker er innlogget
	 * 
	 * @param request
	 *            request
	 * @return True eller false
	 */
	public static boolean erInnlogget(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return (session != null) && (session.getAttribute("innloggetDeltager") != null);
	}

	/**
	 * Returnerer innlogget deltager
	 * 
	 * @param request
	 *            request
	 * @param nummer
	 *            Deltagerens nummer
	 * @return Innlogget deltager
	 */
	public static DeltagerEntity erInnloggetSom(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return erInnlogget(request) ? (DeltagerEntity) session.getAttribute("innloggetDeltager") : null;
	}

	/**
	 * Logger ut "eldre" deltagere, før metoden logger deg inn og setter timeout
	 * 
	 * @param request
	 *            request
	 * @param nummer
	 *            Deltagers nummer
	 * @param timeout
	 *            Timeout på innlogging
	 */
	public static void loggInnSom(HttpServletRequest request, DeltagerEntity deltager, String timeout) {
		loggUt(request);
		HttpSession session = request.getSession(true);
		session.setAttribute("innloggetDeltager", deltager);
		session.setMaxInactiveInterval(Integer.parseInt(timeout));
	}

	/**
	 * Logger deltageren ut
	 * 
	 * @param request
	 *            request
	 */
	public static void loggUt(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
}
