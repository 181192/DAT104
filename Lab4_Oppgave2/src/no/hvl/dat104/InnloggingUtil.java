package no.hvl.dat104;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class InnloggingUtil {
    public static boolean isGyldigBrukernavn(String brukernavn) {
        return brukernavn != null && brukernavn.equals("admin");
    }

    public static boolean isInnlogget(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        return (session != null)
                && (session.getAttribute("innloggetBruker") != null);
    }

    public static String isInnloggetSom(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        return isInnlogget(request) ?
                (String) session.getAttribute("innloggetBruker") : null;
    }

    public static void loggInnSom(HttpServletRequest request, String brukernavn) {

        loggUt(request);
        HttpSession sesjon = request.getSession(true);
        sesjon.setAttribute("innloggetBruker", brukernavn);
    }

    public static void loggUt(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
