package no.hvl.dat104.controller.kasserer;

import static no.hvl.dat104.controller.UrlMappings.BETALINGSOVERSIKT_URL;
import static no.hvl.dat104.controller.UrlMappings.KASSERERLOGIN_URL;
import static no.hvl.dat104.controller.UrlMappings.MOBILLOGIN_URL;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.dataaccess.IDeltagerEAO;
import no.hvl.dat104.model.DeltagerEntity;
import no.hvl.dat104.util.DeltagerUtil;
import no.hvl.dat104.util.InnlogginUtil;

/**
 * Servlet implementation class KassererLoginServlet
 */
public class KassererLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IDeltagerEAO deltagerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (InnlogginUtil.erInnlogget(request)) {
			DeltagerEntity d = DeltagerUtil.hentDeltager(request, deltagerEAO);
			if (d != null && d.getErKasserer()) {
				response.sendRedirect(BETALINGSOVERSIKT_URL);
			} else {
				response.sendRedirect(MOBILLOGIN_URL);
			}
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/kasserer/kassererlogin.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DeltagerEntity d = DeltagerUtil.hentDeltager(request, deltagerEAO);
		if (d != null) {
			// TODO fikse bug med at getInitParameter returnerer null
			// String timeout = getServletContext().getInitParameter("timeout");
			String timeout = "30";
			System.out.println("Logginnsom " + d.getMobil().toString());
			InnlogginUtil.loggInnSom(request, d, timeout);
			response.sendRedirect(BETALINGSOVERSIKT_URL);
		} else {
			response.sendRedirect(KASSERERLOGIN_URL);
		}
	}

}
