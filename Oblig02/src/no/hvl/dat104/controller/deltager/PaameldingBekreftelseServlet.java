package no.hvl.dat104.controller.deltager;

import static no.hvl.dat104.controller.UrlMappings.PAAMELDING_URL;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaaMeldingBekreftelse
 */
public class PaameldingBekreftelseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ((boolean) request.getSession().getAttribute("registrert")) {
			request.getRequestDispatcher("WEB-INF/jsp/deltager/paameldingsbekreftelse.jsp").forward(request, response);
		} else {
			response.sendRedirect(PAAMELDING_URL);
		}
	}

}
