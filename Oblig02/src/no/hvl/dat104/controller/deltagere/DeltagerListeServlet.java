package no.hvl.dat104.controller.deltagere;

import static no.hvl.dat104.controller.UrlMappings.MOBILLOGIN_URL;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.util.InnlogginUtil;

/**
 * Servlet implementation class DeltagerListeServlet
 */
public class DeltagerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (InnlogginUtil.erInnlogget(request)) {
			request.getRequestDispatcher("WEB-INF/jsp/deltagere/deltagerliste.jsp").forward(request, response);
		} else {
			response.sendRedirect(MOBILLOGIN_URL);
		}
	}

}
