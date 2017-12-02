package no.kalli.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
    /**
     * Finner cookie på navn. Hvis ingen cookie matcher navnet returnerer metoden defaultValue
     * @param request
     * @param cookieName
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        String k = null;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i ++) {
                Cookie cookie = cookies[i];
                if (cookieName.equals(cookie.getName())) {
                    k = (cookie.getValue());
                }
            }
        }
        return k;
    }

    /**
     * Finner cookie på navn og returnerer
     * @param request
     * @param cookieName
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i ++) {
            Cookie cookie = cookies[i];
            if (cookieName.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
