package no.hvl.dat104.no.hvl.dat104.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        try {
            request.getRequestDispatcher("error.jsp").include(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}
