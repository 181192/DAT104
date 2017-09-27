package no.hvl.dat104.controller;

import static no.hvl.dat104.controller.UrlMappings.DELTAGERLISTE_URL;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LandingServlet
 */
public class LandingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(DELTAGERLISTE_URL).forward(request, response);
	}
}
