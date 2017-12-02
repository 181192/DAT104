package no.kalli.util;

import no.kalli.Attributter;
import no.kalli.model.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class InnloggingUtil {
    public static boolean erInnlogget(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute(Attributter.STUDENT) != null;
    }

    public static void loggInnSomStudent(HttpServletRequest request, Student s) {
        loggUt(request);
        request.getSession(true).setAttribute(Attributter.STUDENT, s);
        request.getSession(true).setMaxInactiveInterval(60);

    }

    public static void loggUt(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

}
