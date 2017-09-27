package no.hvl.dat104.controller.kasserer;

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
 * Servlet implementation class BetalingsOversiktServlet
 */
public class BetalingsOversiktServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IDeltagerEAO deltagerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (InnlogginUtil.erInnlogget(request)) {
			DeltagerEntity d = DeltagerUtil.hentDeltager(request, deltagerEAO);
			if (d != null && d.getErKasserer()) {
				request.getRequestDispatcher("WEB-INF/jsp/kasserer/betalingsoversikt.jsp").forward(request, response);
			} else {
				response.sendRedirect(MOBILLOGIN_URL);
			}
		} else {
			response.sendRedirect(KASSERERLOGIN_URL);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
