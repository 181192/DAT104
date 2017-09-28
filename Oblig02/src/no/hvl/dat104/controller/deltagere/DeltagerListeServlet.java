package no.hvl.dat104.controller.deltagere;

import static no.hvl.dat104.controller.UrlMappings.MOBILLOGIN_URL;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.dataaccess.IDeltagerEAO;
import no.hvl.dat104.model.DeltagerEntity;
import no.hvl.dat104.util.InnlogginUtil;

/**
 * Servlet implementation class DeltagerListeServlet
 */
public class DeltagerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IDeltagerEAO deltagerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (InnlogginUtil.erInnlogget(request)) {
			List<DeltagerEntity> deltagere = deltagerEAO.alleDeltagere();
			request.setAttribute("deltagere", deltagere);
			request.getRequestDispatcher("WEB-INF/jsp/deltagere/deltagerliste.jsp").forward(request, response);
		} else {
			response.sendRedirect(MOBILLOGIN_URL);
		}
	}

}
