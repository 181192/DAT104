package no.hvl.dat104.controller.deltager;

import static no.hvl.dat104.controller.UrlMappings.DELTAGERLISTE_URL;
import static no.hvl.dat104.controller.UrlMappings.MOBILLOGIN_URL;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.util.InnlogginUtil;

/**
 * Servlet implementation class PaameldingServlet
 */
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (InnlogginUtil.erInnlogget(request)) {
			response.sendRedirect(DELTAGERLISTE_URL);
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/deltager/paameldingsskjema.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!InnlogginUtil.erInnlogget(request)) {
			// Valider input og legg til bruker i DB
		} else {
			response.sendRedirect(DELTAGERLISTE_URL);
		}
		response.sendRedirect(MOBILLOGIN_URL);
	}

}
