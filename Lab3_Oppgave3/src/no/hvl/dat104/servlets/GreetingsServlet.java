package no.hvl.dat104.servlets;

import no.hvl.dat104.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GreetingsServlet", urlPatterns = "/greetings")
public class GreetingsServlet extends HttpServlet {
    private String name;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        name = request.getParameter("name");

        if (!Validator.validerNavn(name)) {
//            response.sendRedirect("error");
            response.sendError(500);
        } else {
            request.getSession().setAttribute("name", name);
            response.sendRedirect("greetings");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        name = (String) request.getSession().getAttribute("name");

        response.setContentType("text/html; charset=ISO-8859-1");

        try {
            request.getSession().setAttribute("name", name);
            request.getRequestDispatcher("greetings.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
