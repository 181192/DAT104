package no.hvl.dat104.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static no.hvl.dat104.controller.UrlMappings.LANDING_URL;
import static no.hvl.dat104.controller.UrlMappings.LOGIN_URL;

@WebServlet(name = "LandingServlet", urlPatterns = "/" + LANDING_URL)
public class LandingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(LOGIN_URL);
    }
}
