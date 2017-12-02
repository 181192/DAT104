package no.kalli.util;

import javax.servlet.http.HttpServletRequest;

public class FlashUtil {
    public static void Flash(HttpServletRequest request, String flash, String melding) {
        request.getSession().setAttribute("melding", melding);
        request.getSession().setAttribute("flash", flash);
    }
}
