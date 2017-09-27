package no.hvl.dat104.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class InnlogginUtil {
	
	public static boolean erInnlogget(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return (session != null) && (session.getAttribute("innloggetDeltager") != null);
	}
	
	public static String erInnloggetSom(HttpServletRequest request, Integer nummer) {
		HttpSession session = request.getSession(false);
		return erInnlogget(request) ? (String) session.getAttribute("innloggetDeltager") : null;
	}
	
	public static void loggInnSom(HttpServletRequest request, Integer nummer) {
		loggUt(request);
		HttpSession session = request.getSession(true);
		session.setAttribute("innloggetDeltager", nummer);
	}
	
	public static void loggUt(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
}
