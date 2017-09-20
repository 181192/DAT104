package no.hvl.dat104.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class InnloggingUtil {

    public static boolean isGyldigBrukernavn(String brukernavn) {
        return brukernavn != null;
    }

    public static boolean isInnlogget(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        return (session != null)
                && (session.getAttribute("loggedInUser") != null);
    }

    public static String isInnloggetSom(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        return isInnlogget(request) ?
                (String) session.getAttribute("loggedInUser") : null;
    }

    public static void loggInnSom(HttpServletRequest request, String brukernavn) {

        loggUt(request);
        HttpSession sesjon = request.getSession(true);
        sesjon.setAttribute("loggedInUser", brukernavn);
    }

    public static void loggUt(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
