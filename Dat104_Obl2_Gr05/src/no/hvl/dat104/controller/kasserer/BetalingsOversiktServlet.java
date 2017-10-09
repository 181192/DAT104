package no.hvl.dat104.controller.kasserer;

import static no.hvl.dat104.controller.UrlMappings.BETALINGSOVERSIKT_URL;
import static no.hvl.dat104.controller.UrlMappings.KASSERERLOGIN_URL;
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
import no.hvl.dat104.util.ValideringUtil;

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
			DeltagerEntity d = InnlogginUtil.erInnloggetSom(request);
			if (d != null && d.getErKasserer()) {
				List<DeltagerEntity> deltagere = deltagerEAO.alleDeltagere();
				request.setAttribute("deltagere", deltagere);
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
		String nummer = ValideringUtil.escapeHTML(request.getParameter("mobil"));
		if (ValideringUtil.validerNummer(nummer)) {
			DeltagerEntity d = deltagerEAO.finnDeltager(Integer.parseInt(nummer));
			if (d != null) {
				d.setHarBetalt(true);
				deltagerEAO.oppdaterDeltager(d);
				
			}
		}
		response.sendRedirect(BETALINGSOVERSIKT_URL);
	}

}
