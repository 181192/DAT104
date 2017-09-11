package no.hvl.dat104.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HemmeligServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Krever at bruker er innlogget!
        // Hvis bruker er innlogget vises siden. Hvis ikke sendes bruker til
        // innloggingsside med melding om at man må være innlogget for å se
        // siden

        response.setContentType("text/html; charset=ISO-8859-1");
        try {
            request.getRequestDispatcher("hemmelig.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
