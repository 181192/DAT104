package no.hvl.dat104;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet(name = "RegistrerServlet", urlPatterns = "/")
public class RegistrerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        if (haveCookies(request)) {
            String fname = findCookies(request, "fname");
            String lname = findCookies(request, "lname");

            System.out.println("doGet " + fname + " " + fname);

            request.getSession().setAttribute("fname", fname);
            request.getSession().setAttribute("lname", lname);
        }

        try {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String fname = URLEncoder.encode(request.getParameter("fname"), "ISO-8859-1");
        String lname = URLEncoder.encode(request.getParameter("lname"), "ISO-8859-1");
        newCookie(response, "fname", fname);
        newCookie(response, "lname", lname);

        System.out.println("doPost " + fname + " " + fname);

        response.sendRedirect(request.getContextPath());

    }

    private boolean haveCookies(HttpServletRequest request) {
        return request.getCookies() != null;
    }

    private void newCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60);
        response.addCookie(cookie);
    }

    private String findCookies(HttpServletRequest request, String value) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(value)) {
                    return URLDecoder.decode(cookie.getValue(), "ISO-8859-1");
                }
            }
        }
        return null;
    }
}
