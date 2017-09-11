package no.hvl.dat104.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoggInnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // «Logg inn»-knappen. Hvis brukernavn er korrekt (= «admin») logges
        // man inn og sendes til hemmelig side. Hvis ikke sendes bruker tilbake
        // til innloggingssiden med melding om at brukernavn er feil.

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Viser innloggingsskjema med evt. feilmelding.

        response.setContentType("text/html; charset=ISO-8859-1");
        try {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
