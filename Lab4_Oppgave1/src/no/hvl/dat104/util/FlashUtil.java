package no.hvl.dat104.util;

import javax.servlet.http.HttpServletRequest;

public class FlashUtil {
    public static void flash(HttpServletRequest request, String flash, String message) {
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("flash", flash);
    }

    public static void loggedInn(HttpServletRequest request, String username) {
        String flash = "Success";
        String message = "Velkommen: " + username;
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("flash", flash);
    }

    public static void unValidUser(HttpServletRequest request) {
        String message = "Ugyldig innlogging";
        String flash = "Error";
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("flash", flash);
    }

    public static void loggedOut(HttpServletRequest request) {
        String message = "Du ble logget ut";
        String flash = "Success";
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("flash", flash);
    }

    public static void registerUser(HttpServletRequest request) {
        String message = "Velkommen til din handleliste";
        String flash = "Success";
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("flash", flash);
    }

    public static void unValidRegisterUser(HttpServletRequest request) {
        String message = "Ugyldig input";
        String flash = "Error";
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("flash", flash);
    }

    public static void needToBeLoggedIn(HttpServletRequest request) {
        String message = "Du må være innlogget for å gjøre det!";
        String flash = "Error";
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("flash", flash);
    }
}
